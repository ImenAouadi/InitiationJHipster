import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IGame, Game } from 'app/shared/model/game.model';
import { GameService } from './game.service';

@Component({
  selector: 'jhi-game-update',
  templateUrl: './game-update.component.html',
})
export class GameUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    level: [],
    categorie: [null, [Validators.required]],
    idAccount: [null, [Validators.required]],
  });

  constructor(protected gameService: GameService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ game }) => {
      this.updateForm(game);
    });
  }

  updateForm(game: IGame): void {
    this.editForm.patchValue({
      id: game.id,
      name: game.name,
      level: game.level,
      categorie: game.categorie,
      idAccount: game.idAccount,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const game = this.createFromForm();
    if (game.id !== undefined) {
      this.subscribeToSaveResponse(this.gameService.update(game));
    } else {
      this.subscribeToSaveResponse(this.gameService.create(game));
    }
  }

  private createFromForm(): IGame {
    return {
      ...new Game(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      level: this.editForm.get(['level'])!.value,
      categorie: this.editForm.get(['categorie'])!.value,
      idAccount: this.editForm.get(['idAccount'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IGame>>): void {
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
