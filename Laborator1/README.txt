Proiectul contine clasa principala Main, in care am declarat un obiect lab1 de tip Main. Pentru acest obiect am apelat pe rand metodele pe care le contine clasa, respectiv compulsory(), homework(args) si bonus().
Datorita faptului ca acest program necesita si argumente care vor fi preluate in String[] args, am facut si o validare ca parametrii sunt cel putin 3. In cazul in care avem cel putin 3 argumente, verific folosind functia isPositiveAndNumeric daca primele 2 argumente sunt de tip numeric si pozitive. (Daca primul caracter al stringului este '-', am considerat ca ar putea fi un numar negativ si functia returneaza fals, iar programul isi termina executia)
Daca cele 2 argumente sunt numerice si pozitive atunci folosind functia areLetters(String[] args) va verifica daca fiecare caracter de la pozitia 2 este litera, iar daca rezultatul este fals atunci se va termina executia programului.

1. Compulsory:
Metoda compulsory va afisa prima data pe ecran mesajul "Hello World". Am creat apoi un array de string-uri. Am creat o variabila n ce va lua o valoare random intre 0 si 999999, apoi am inmultit numarul cu 3, am adunat numarul 0b10101 si 0xFF convertite in baza 2, respectiv 16, apoi am inmultit cu 6. Am creat apoi variabila result ce va calcula suma cifrelor unui numar pana cand suma este de o singura cifra (in cazul in care dupa o iteratie rezultatul are mai multe cifre, se va actualiza result-ul cu 0 si noul n cu valoarea result-ului calculat anterior), apoi am afisat string-ul de la pozitia result.

2. Homework: 
Metoda homework are pentru inceput 2 variabile n si p, corespunzatoare primelor doua argumente date si un array de char-uri in care vor fi salvate literele ce pot alcatui cuvinte(tot date ca argumente). Apoi am creat un array de string-uri de marime p in care se vor salva n cuvinte. Daca n este mai mare decat 30.000 atunci doar se creeaza cuvintele fara a fi afisate. Cuvintele sunt create apeland functia createRandWord: functia construieste un string in functie de un k (corespunzator pozitiei din alfabetul disponibil) care este generat random pentru fiecare iteratie
a buclei for; dupa cele p caractere adaugate, se returneaza reprezentarea obiectului ca un string. 

Dupa ce s-au creat cele n cuvinte, am creat o matrice de tip boolean in care am salvat daca 2 cuvinte sunt vecine(false-> nu sunt vecine, true->sunt vecine) astfel: daca am ajuns in punctul de a verifica daca un cuvant este vecin cu el insusi, atunci in matrice se va pune false, altfel verific folosind functia foundCommonLetter daca am gasit cel putin o litera comuna, caz in care voi pune in matrice true, altfel false. Functia foundCommonLetter va parcurge fiecare litera din primul cuvant si va verifica daca al doilea cuvant va contine litera respectiva (wordTwo.contains(letter)): daca da, atunci sunt vecini, altfel daca ajung pana la finalul cuvantului unu, nu sunt vecini.
Pentru structura care salveaza vecinii am folosit tot o matrice de string-uri, ce va contine cuvintele ce au true in matricea de adiacenta. In cazul in care n este mai mic decat 30000 voi afisa matricea de vecini, altfel afisez timpul in nanosecunde pentru cat dureaza operatiile anterioare.

3. Bonus:
Nu am implementat inca.

Nu am reusit sa afisez timpul in cazul in care n > 30.000. Programul afiseaza timpul cand n este maxim 20150.