package sarasai;

public class MyList {

    private Object[] list;

    public MyList() {
        this.list = new Object[0];
    }

    public void add(Object o) {
        // sukuriam nauja masyva, vienu elementu didesni negu buvo
        Object[] newList = new Object[this.list.length + 1];

        // nukopijuojam is seno masvyo visas esamas reiksmes
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }

        // i paskutine (nauja) vieta irasom nuoroda i prideta objekta
        newList[newList.length - 1] = o;

        // nuo siol naudosimes ilgesniu masyvu
        this.list = newList;
    }

    public void remove(int index) {
        // jei index < 0 arba didesnis arba lygus uz esama saraso ilgi - nedaro nieko
        if (index < 0) {
            throw new NecheckedKlaida("indeksas yra neigiamas skaicius");
        }
        if (index >= this.list.length) {
            throw new NecheckedKlaida("indeksas yra didesnis skaicius  uz saraso ilgi");
        }
        Object[] listRem = new Object[this.list.length - 1];
        for (int i = 0, j = 0; i < this.list.length; i++) {
            if (i != index) {
                listRem[j++] = this.list[i];
            }
        }
        this.list = listRem;
    }

    public Object get(int index) {
        // cia dar reikia pataisyt
        if (index < 0) {
            throw new NecheckedKlaida("indeksas yra neigiamas skaicius");
        }
        if (index >= this.list.length) {
            throw new NecheckedKlaida("indeksas yra didesnis skaicius uz saraso ilgi");
        }
        return this.list[index];
    }

    public void set(int index, Object o) {
        if (index < 0 || index >= this.list.length) {
            return;
        }
        this.list[index] = o;
    }

    public void insert(int index, Object o) {
        // jei index < 0 arba didesnis arba lygus uz esama saraso ilgi - nedaro nieko
        if (index < 0) {
            throw new NecheckedKlaida("indeksas yra neigiamas skaicius");
        }
        if (index >= this.list.length) {
            throw new NecheckedKlaida("indeksas yra ilgesnis uz saraso ilgi");
        }
        Object[] listInsert = new Object[this.list.length + 1];

        for (int i = 0, j = 0; i < this.list.length + 1; i++) {
            if (i == index) {
                listInsert[i] = o;
            } else {
                listInsert[i] = this.list[j++];
            }
        }
        this.list = listInsert;
    }

    public int size() {
        return this.list.length;
    }

    public String toString() {
        // turi grazinti tikra reiksme
        // kolkas grazinam ""
        String s = "{";
        for (int i = 0; i < this.list.length; i++) {
            if (i > 0) {
                s += ", ";
            }
            s += this.list[i];
        }
        s += "}";
        return s;
    }
}

/*
Susikurti unchecked klaidos klase 
ir metoduose remove, insert, get throw'inti klaida
 */
