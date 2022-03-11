package dataStra;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class MyArrayList {
    private int[] elements;
    private int counter = 0;
    private final int DEFAULT_SIZE = 10;
    private int size = DEFAULT_SIZE;
    
    /**
     * Bez argumenta konstruktors, ja lietotajs nezin cik lielam jabut sarakstam
     */
    public MyArrayList(){
        elements = new int[size];
    }

    /**
     * Argumenta konstruktors, kur lietotajs padod velamo lielumu
     * @param size konstruktora velamais lielums
     */
    public MyArrayList(int inputSize){
        if(inputSize > 0){
            size = inputSize;
        }
        elements = new int[size];
    }

    /**
     * Noskaidro vai saraksts ir pilns
     * @return bool kas pasaka vai saraksts ir pilns vai ne
     */
    public boolean isFull(){
        return (counter == size)? true: false;
    }

    /**
     * Noskaidro vai saraksts ir tukss
     * @return bool, kas pasaka vai saraksts ir tukss
     */
    public boolean isEmpty(){
        return (counter == 0)? true: false;
    }

    public int getSize(){
        return size;
    }

    /**
     * Palielina saraksta lieluma 2 vai 1.5 reizes
     */
    private void resize(){
        
        if(counter < 100){
            size *= 2;
        } else {
            size = (int)(size* 1.5);
        }
        // size = (counter < 100)? size*2 : (int)(size*1.5);
        int[] elementsNew = new int[size];

        for (int i = 0; i < counter; i++){
            elementsNew[i] = elements[i];
        }
        elements = elementsNew;
        System.gc();
    }

    //1.funkcijas dekleracija
    //2.parbaudam vai saraksts ir pilns
    //2.1 ja ir, tad izsauc resize()
    //3. ievietojam elementu pie pedeja elementa
    //4.japalielina skaititajs

    /**
     * Ievieto jauno elementu pec pedeja elementa saraksta
     * @param elem elements kuru pievienos
     */
    public void add(int elem){
        if(isFull()){
            resize();
        }

        elements[counter] = elem;
        counter++;
    }

    /**
     * Pievienot sarakstam elementu pec savas izveletas pozicijas
     * @param elem
     * @param pos
     * @throws Exception
     */
    public void add(int elem, int pos) throws Exception{
        if(pos > counter){pos = counter;}
        if(pos >= 0 && pos <= counter){
            if(isFull()){resize();}
            for (int i = counter; i > pos; i--){
                elements[i] = elements[i-1];
            }
            elements[pos] = elem;
            counter++;
        } else {
            Exception exc = new Exception("Neatbilstosa ievadita pozicija");
            throw exc;
        }
    }

    // 1.funkcijas dekleracija
    // 2.parbaudit vai nav tukss
    // 3.parbaudit vai ir atbilstosa pozicija
    // 4.veikt kopesanu uz kreiso pusi lidz pat pozicijai
    // 5.samazinat skaititaju
    /**
     * Iznemt elementu no izveletas pozicijas
     * @param pos
     * @throws Exception
     */
    public void remove(int pos)throws Exception{
        if(isEmpty()){
            Exception exc = new Exception("Saraksts tukss");
            throw exc;
        } else {
            if(pos >= 0 && pos <= counter){
                for(int i = pos; i <= counter-1; i++){
                    elements[i] = elements[i+1];
                }
                counter--;
            } else {
                Exception exc = new Exception("Neatbilstosa ievadita pozicija");
                throw exc;
            }
        }
    }

    public void getList(){
        System.out.print("[" + elements[0]);
        for (int i = 1; i < counter; i++){
            System.out.print(", " + elements[i]);
        }
        System.out.println("]");
    }

    /**
     * Atgriez elementu dotaja pozicija
     * @param pos
     * @return
     * @throws Exception
     */
    public int retrieve(int pos) throws Exception{
        if(isEmpty()){
            Exception exc = new Exception("Saraksts tukss");
            throw exc;
        } else {
                if(pos >= 0 && pos <= counter){
                    return elements[pos];
                } else {
                    Exception exc = new Exception("Neatbilstosa ievadita pozicija");
                    throw exc;
                }
            }
    }
    /**
     * Meklē konkrētu elementu un atgriež tā pozīciju. Iespējams arī vairāki venādi elementi sarakstā
     * @param elem
     * @return
     * @throws Exception
     */
    public int[] search(int elem) throws Exception {
        if (!isEmpty()) {
                int counterTemp = 0;
                for (int i = 0; i < counter; i++) {
                        if (elements[i] == elem) {
                                counterTemp++;
                        }
                }

                if (counterTemp != 0) {
                        int[] positions = new int[counterTemp];

                        int positionCounter = 0;
                        for (int i = 0; i < counter; i++) {
                                if (elements[i] == elem) {
                                        positions[positionCounter] = i;
                                        positionCounter++;
                                }
                        }
                        return positions;
                } else {
                        Exception exc = new Exception("Meklētais elements nav atrasts");
                        throw exc;
                }
        } else {
                Exception exc = new Exception("Saraksts ir tukšs un tajā neko nevar atrast");
                throw exc;
        }

}
    /**
     * Iegūst visus nākamos elemntu vērtības, ja tiek padots konkrēts elements
     * @param index
     * @return
     * @throws Exception
     */
    public int[] nextElem(int index)throws Exception{
        
        if(isEmpty()){
            Exception exc = new Exception("Masīvs tukšs");
            throw exc;
        } else{
            int[] positions = search(index);
            int[] allNextElements = new int[positions.length];
            for(int i = 0; i < positions.length; i++){
                int posTemp = positions[i];
                if(posTemp<counter-1){
                    allNextElements[i] = elements[posTemp+1];

                }
            }
            return allNextElements;
        }
        
    }
    /**
     * Veic saraksta kārtošanu
     */
    public void sortList(){
        //Arrays.sort(elements);
        for (int i = 0; i < counter; i++){
            for(int j = 0; j< counter; j++){
                if(elements[i] < elements[j]){
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    /**
     * Iztīra sarakstu
     */
    public void clearList(){
        // int[] tukssElements = new int[size];
        // elements = tukssElements;
        // System.gc();

        elements = new int [size];
        counter = 0;
        System.gc();
    }

}
