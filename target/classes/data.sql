--Registros tabla TIPO
INSERT INTO Tipo(Id, Tipo) VALUES(1, 'Fijo');
INSERT INTO Tipo(Id, Tipo) VALUES(2, 'Ley Puente Festivo');
INSERT INTO Tipo(Id, Tipo) VALUES(3, 'Basado en Pascua');
INSERT INTO Tipo(Id, Tipo) VALUES(4, 'Basado en Pascua y Ley Puente Festivo');

--Registros tabla FESTIVO
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(1,1, 1, 'Año nuevo', 1, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(2,6, 1, 'Santos Reyes', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(3,19, 3, 'San José', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(4,0, 0, 'Jueves Santo', 3, -3);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(5,0, 0, 'Viernes Santo', 3, -2);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(6,0, 0, 'Domingo de Pascua', 3, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(7,1, 5, 'Día del Trabajo', 1, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(8,0, 0, 'Ascensión del Señor', 4, 40);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(9,0, 0, 'Corpus Christi', 4, 61);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(10,0, 0, 'Sagrado Corazón de Jesús', 4, 68);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(11,29, 6, 'San Pedro y San Pablo', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(12,20, 7, 'Independencia Colombia', 1, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(13,7, 8, 'Batalla de Boyacá', 1, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(14,15, 8, 'Asunción de la Virgen', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(15,12, 10, 'Día de la Raza', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(16,1, 11, 'Todos los santos', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(17,11, 11, 'Independencia de Cartagena', 2, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(18,8, 12, 'Inmaculada Concepción', 1, 0);
INSERT INTO Festivo (Id,Dia, Mes, Nombre, IdTipo, DiasPascua) VALUES(19,25, 12, 'Navidad', 1, 0);
