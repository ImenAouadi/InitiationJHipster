import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPlayer, Player } from 'app/shared/model/player.model';
import { PlayerService } from './player.service';

@Component({
  selector: 'jhi-player-update',
  templateUrl: './player-update.component.html',
})
export class PlayerUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    avatar: [null, [Validators.required]],
    score: [null, [Validators.required]],
    idAccount: [null, [Validators.required]],
  });

  constructor(protected playerService: PlayerService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ player }) => {
      this.updateForm(player);
    });
  }

  updateForm(player: IPlayer): void {
    this.editForm.patchValue({
      id: player.id,
      avatar: player.avatar,
      score: player.score,
      idAccount: player.idAccount,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const player = this.createFromForm();
    if (player.id !== undefined) {
      this.subscribeToSaveResponse(this.playerService.update(player));
    } else {
      this.subscribeToSaveResponse(this.playerService.create(player));
    }
  }

  private createFromForm(): IPlayer {
    return {
      ...new Player(),
      id: this.editForm.get(['id'])!.value,
      avatar: this.editForm.get(['avatar'])!.value,
      score: this.editForm.get(['score'])!.value,
      idAccount: this.editForm.get(['idAccount'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPlayer>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
