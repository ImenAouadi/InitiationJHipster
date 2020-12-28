import { ITeam } from 'app/shared/model/team.model';

export interface IPlayer {
  id?: number;
  avatar?: string;
  score?: number;
  idAccount?: string;
  teams?: ITeam[];
}

export class Player implements IPlayer {
  constructor(public id?: number, public avatar?: string, public score?: number, public idAccount?: string, public teams?: ITeam[]) {}
}
