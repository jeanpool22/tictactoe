public class WinConditionThree {
    public static boolean check(int[][][] gameState, int row, int col, int player) {
        // Verificar si los tres anillos en la misma posición tienen el mismo color
        return gameState[row][col][0] == player && gameState[row][col][1] == player && gameState[row][col][2] == player;
    }
}
