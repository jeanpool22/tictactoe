public class WinConditionOne {
    public static boolean check(int[][][] gameState, int row, int col, int ringSize) {
        // Obtiene el jugador que ha colocado el anillo en la posición especificada
        int player = gameState[row][col][ringSize];

        // Verificar filas
        /*
            Recorre la fila especificada (row) y verifica si todos los anillos en esa fila pertenecen al jugador.
            Si encuentra un anillo que no pertenece al jugador, sale del bucle (break).
            Si todos los anillos en la fila pertenecen al jugador, devuelve true indicando una victoria.
        */
        for (int i = 0; i < 3; i++) {
            if (gameState[row][i][ringSize] != player) {
                // Si algún anillo en la fila no pertenece al jugador, salir del bucle
                break;
            }
            if (i == 2) {
                // Si todos los anillos en la fila pertenecen al jugador, hay una victoria
                return true;
            }
        }

        // Verificar columnas
        /*
            Recorre la columna especificada (col) y verifica si todos los anillos en esa columna pertenecen al jugador.
            Si encuentra un anillo que no pertenece al jugador, sale del bucle (break).
            Si todos los anillos en la columna pertenecen al jugador, devuelve true indicando una victoria.
        */
        for (int i = 0; i < 3; i++) {
            if (gameState[i][col][ringSize] != player) {
                // Si algún anillo en la columna no pertenece al jugador, salir del bucle
                break;
            }
            if (i == 2) {
                // Si todos los anillos en la columna pertenecen al jugador, hay una victoria
                return true;
            }
        }

        // Verificar diagonal
        /*
            Verifica si la posición (row, col) está en la diagonal principal (row == col).
            Si está en la diagonal principal, recorre la diagonal y verifica si todos los anillos en esa diagonal pertenecen al jugador.
            Si encuentra un anillo que no pertenece al jugador, sale del bucle (break).
            Si todos los anillos en la diagonal pertenecen al jugador, devuelve true indicando una victoria.
        */
        if (row == col) {
            for (int i = 0; i < 3; i++) {
                if (gameState[i][i][ringSize] != player) {
                    // Si algún anillo en la diagonal no pertenece al jugador, salir del bucle
                    break;
                }
                if (i == 2) {
                    // Si todos los anillos en la diagonal pertenecen al jugador, hay una victoria
                    return true;
                }
            }
        }

        // Verificar diagonal inversa
        /*
            Verifica si la posición (row, col) está en la diagonal inversa (row + col == 2).
            Si está en la diagonal inversa, recorre la diagonal inversa y verifica si todos los anillos en esa diagonal pertenecen al jugador.
            Si encuentra un anillo que no pertenece al jugador, sale del bucle (break).
            Si todos los anillos en la diagonal inversa pertenecen al jugador, devuelve true indicando una victoria.
        */
        if (row + col == 2) {
            for (int i = 0; i < 3; i++) {
                if (gameState[i][2 - i][ringSize] != player) {
                    // Si algún anillo en la diagonal inversa no pertenece al jugador, salir del bucle
                    break;
                }
                if (i == 2) {
                    // Si todos los anillos en la diagonal inversa pertenecen al jugador, hay una victoria
                    return true;
                }
            }
        }

        // Si ninguna condición de victoria se cumple, devolver false
        return false;
    }
}
