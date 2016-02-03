package skokie;

import static java.lang.Math.abs;

public class SkokiE {

    public static double[][] foo(double tab[][], int K, int P) {
        double max = 0;
        double min = 0;
        double sum = 0;
        double sumaOcen = 0;
        for (int wier = 0; wier < tab.length; wier++) {
            
            for (int kolumn = 0; kolumn < tab[wier].length - 1; kolumn++) {

                double roznica;
                roznica = abs(K - tab[wier][1]);

                if (tab[wier][1] > K) {
                    sum = 60 + (roznica * P);
                } else {
                    sum = 60 - (roznica * P);
                }
            }

            for (int i = 0; i < tab.length; i++) {
                for (int j = 2; j < 7; j++) {
                    if (tab[i][j] > tab[i][j + 1]) {
                        max = tab[i][j];
                    } else {
                        min = tab[i][j + 1];
                    }

                }
                for (int j = 2; j < tab[i].length; j++) {
                    sumaOcen += tab[i][j];
                    tab[i][7] = sum + sumaOcen - (min + max);
                }
                sumaOcen = 0;

            }
        }

        return tab;
    }

    public static void main(String[] args) {

        double[][] skoki = {{1, 110, 15.6, 14.8, 14.8, 11.2, 12.1, 0},
        {2, 108, 15.6, 14.8, 12.8, 11.2, 12.1, 0},
        {3, 111, 17.6, 16.8, 14.8, 15.2, 12.1, 0},
        {4, 134, 15.6, 13.8, 19.8, 14.2, 12.1, 0},
        {5, 118, 19.6, 14.8, 14.8, 11.2, 12.1, 0}};

        int rozmiar;

        for (int i = 0; i < skoki.length; i++) {
            for (int j = 0; j < skoki[i].length; j++) {
                System.out.print(skoki[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------");
        skoki = foo(skoki, 110, 1);

        for (int i = 0; i < skoki.length; i++) {
            for (int j = 0; j < skoki[i].length; j++) {
                System.out.print(skoki[i][j] + " ");
            }
            System.out.println();
        }
//        int z=1;
//        for(int i=8; i>= 0; i--)
//        {
//            z*=2;
//        }
//        System.out.println("z" + z);
    }

}
/*
 Dana jest tablica 2-wymiarowa zawierająca w każdym wierszu 8 kolumn:
 . nr skoczka
 . odległość
 . 5 ocen sędziów
 . miejsca na końcową liczbę punktów
 Napisać funkcję: skoki(double tab[][], int K, int P) wypełniającą liczbę punktów wg zasad:
 . długość skoku liczy się jako jego odległość od punktu "K" (punktu konstrukcyjnego), dla którego zawodnik otrzymuje 60pkt.; 
 za każdy metr dalej lub bliżej od punktu "K" skoczek otrzymuje odpowiednio +P lub -P pkt.
 . punkty za styl przyznawane są przez 5 sędziów: 2 skrajne są odrzucane, a 3 pozostałe dodaje się do ogólnej punktacji zawodnika
 . końcowa liczba punktów jest równa sumie liczby punktów za odległość i za styl
 Funkcja zwraca uzupełnioną tablicę.
 */
//package egzamin2014_1;
//
//public class EGZAMIN2014_1 
//{
//    public static void main(String[] args) 
//    {
//        double[][] tab = {{1,150,9,7,8,4,6,0},{2,130,9,7,3,5,7,0},{3,160,7,8,8,9,4,2,},{2,130,9,7,3,5,7,0}};
//        tab = skoki(tab, 135, 5);
//        for(double x[]: tab)
//        {
//            for(double y: x) // zwraca poszczególne wartości 
//            {
//                System.out.print(" "+y);
//            }
//        System.out.println(" ");
//        } 
//    } 
//    /*
//        [1]- odlegosc
//        [2-6]-oceny
//        [7]-koncowa ocena
//        
//        50p     60p     70p 
//        90      100     110
//    */
//        public static double[][] skoki(double tab[][], int K, int P) // tablica jest w parametrze, nie muszę deklarować
//        {
//            for(double[] x: tab )
//            {
//                x[7]=(x[1]-K)*P+60;
//                x[7]+=x[2]+x[3]+x[4]+x[5]+x[6];        
//        // K=100 P=3 105=75
//                x[7]-=(Math.max(x[2], Math.max(x[3], Math.max(x[4], Math.max(x[5],x[6])))));
//                x[7]-=(Math.min(x[2], Math.min(x[3], Math.min(x[4], Math.min(x[5],x[6])))));
//            }        
//        return tab;
//        }
//}
