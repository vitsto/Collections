import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    public static void main(String[] args) {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, "◯");
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(biDemArrList.get(i).get(j) + " ");
                } else {
                    System.out.print("●" + " ");
                }
            }
            System.out.println();
        }
    }
}
