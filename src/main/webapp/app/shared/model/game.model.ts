export interface IGame {
  id?: number;
  name?: string;
  level?: string;
  categorie?: string;
  idAccount?: string;
}

export class Game implements IGame {
  constructor(public id?: number, public name?: string, public level?: string, public categorie?: string, public idAccount?: string) {}
}
