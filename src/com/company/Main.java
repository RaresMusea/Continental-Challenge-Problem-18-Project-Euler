//Project Euler-Problema 18:Maximum Path Sum I
//Realizata de Musea Rares-Gabriel
//Limbaj:Java

//Rationament:
/*  Analizand in detaliu problema,am ajuns la concluzia ca cel mai pun approach pentru solutionarea acestei probleme ar
fi  utilizarea tehnicii programarii dinamice,atat pentru a lucra intr-un mod relativ eficient,pentru a scadea din numarul de iteratii,
dar si pentru a stoca cumva maximele globale si locale,necesare pentru generarea traseului de suma maxima din triunghiul dat.
    Pentru a maximiza rezultatul,dar si pentru a respecta cu fidelitate cerinta standard a problemei,am optat pentru aplicarea metodei
inainte (Pentru rezolvarea problemei se incepe de la starea finala).
 */

//Mod de rezolvare:
/*Am stocat triunghiul intr-un tablou bidimensional de elemente intregi.Pentru solutionare,am lucrat procedural.
* Am definit o functie intitulata FindMaxSum,care primeste ca si argument de intrare un tablou bidimensional.
* Se incepe parcurgerea traseului de lungime maxima de la penultima linie a matricei,intrucat fiecare element de pe linia curenta va trebui comparat
* cu cel de pe linia de dedesubt,pentru identificarea unei valori maxime,care ulterior va fi adaugata la suma maxima.Am prevenit
* ,in acest fel,anumite erori si exceptii de runtime,cum ar fi ArrayIndexOutOfBounds.*/
package com.company;

public class Main {
    //Metoda ce returneaza ruta de suma maxima
    public static long FindMaxSum(long[][] tr){
        //Aplicarea programarii dinamice:
        /*Parcurgem triunghiul,incepand cu penultima linie si continuand cu prima coloana,pana la coloana cu indicele
         aferent liniei Comparam elementele de pe linia curenta si coloana curenta cu cele de pe linia imediat urmatoare
         si coloana imediat urmatoare si in functie de valoarea maxima,
         actualizam triunghiul (matricea/elementul de pe linia curenta). Iteratia continua pana la varful triunghiului,caz in care unica valoare din varf
         va reprezenta si valoarea maxima a sumei.
         */
        for(int i=(tr.length)-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                tr[i][j]+=Math.max(tr[i+1][j],tr[i+1][j+1]);
            }
        }
        //Dupa toate iteratiile,se va returna suma maxima (elementul din varf)
        return tr[0][0];
    }
    public static void main(String[] args) {

        //input
        long[][] triangle = {
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        //Apel la metoda definita mai sus.S-a utilizat keyword-ul static,pentru a nu mai fi nevoiti sa instantiem un nou obiect
        //al clasei Main

        long res=FindMaxSum(triangle);
        //Afisarea rezultatelor
        System.out.println("Ruta de suma maxima este: "+res);

    }
}
