public class WinConditionTwo {
    public static boolean check(int[][][] gameState, int player) {
        // Verificar filas para alineación ascendente y descendente
        for (int row = 0; row < 3; row++) {
            // Alineación ascendente en la fila
            if (gameState[row][0][0] == player && gameState[row][1][1] == player && gameState[row][2][2] == player) {
                return true;
            }

            // Alineación descendente en la fila
            if (gameState[row][0][2] == player && gameState[row][1][1] == player && gameState[row][2][0] == player) {
                return true;
            }
        }

        // Verificar columnas para alineación ascendente y descendente
        for (int col = 0; col < 3; col++) {
            // Alineación ascendente en la columna
            if (gameState[0][col][0] == player && gameState[1][col][1] == player && gameState[2][col][2] == player) {
                return true;
            }

            // Alineación descendente en la columna
            if (gameState[0][col][2] == player && gameState[1][col][1] == player && gameState[2][col][0] == player) {
                return true;
            }
        }

        // Verificar diagonal principal (ascendente y descendente)
        // Alineación ascendente en la diagonal principal
        if (gameState[0][0][0] == player && gameState[1][1][1] == player && gameState[2][2][2] == player) {
            return true;
        }

        // Alineación descendente en la diagonal principal
        if (gameState[0][0][2] == player && gameState[1][1][1] == player && gameState[2][2][0] == player) {
            return true;
        }

        // Verificar diagonal inversa (ascendente y descendente)
        // Alineación ascendente en la diagonal inversa
        if (gameState[0][2][0] == player && gameState[1][1][1] == player && gameState[2][0][2] == player) {
            return true;
        }

        // Alineación descendente en la diagonal inversa
        if (gameState[0][2][2] == player && gameState[1][1][1] == player && gameState[2][0][0] == player) {
            return true;
        }

        // Si ninguna condición de victoria se cumple, devolver false
        return false;
    }
}
