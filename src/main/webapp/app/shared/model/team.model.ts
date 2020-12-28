import { IGame } from 'app/shared/model/game.model';

export interface ITeam {
  id?: number;
  teamName?: string;
  teamMember?: string;
  score?: number;
  games?: IGame[];
}

export class Team implements ITeam {
  constructor(public id?: number, public teamName?: string, public teamMember?: string, public score?: number, public games?: IGame[]) {}
}
