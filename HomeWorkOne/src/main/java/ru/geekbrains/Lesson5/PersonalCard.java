package ru.geekbrains.Lesson5;

public class PersonalCard {
    private static int personNumber = 0;//Статическая переменная - количество сторудников. Количество объектов даного класса.

    private String F_I_O;
    private String position;
    private String eMail;
    private String tel;
    private int salary;
    private int age;
    private int hireOrder;

    public PersonalCard() {
        this.F_I_O = "Default";
        this.position = "Unknown";
        this.eMail = "Unknown";
        this.tel = "70000000000";
        this.salary = 0;
        this.age = 0;
        personNumber++;
        this.hireOrder = personNumber;
        }

    public PersonalCard(String f_I_O, String position, String eMail, String tel, int salary, int age) {
        if (!isTel(tel)) {
            System.out.println("Телефон должен состояить из 11 цифр");
            return;}
        if (!isEMail(eMail)) {
            System.out.println("Почта указана неверно!");
            return;}

        this.F_I_O = f_I_O;
        this.position = position;
        this.eMail = eMail;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
        personNumber++;
        this.hireOrder = personNumber;
    }

    public void setEMail(String eMail) {
        if(isEMail(eMail)) this.eMail = eMail;
        else System.out.println("Не правильно указана почта");
    }

    public void setTel(String tel) {
       if(isTel(tel)) this.tel = tel;
       else System.out.println("телефон должен содержать 11 знаков");
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setF_I_O(String F_I_O) {
        this.F_I_O = F_I_O;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHireOrder(int hireOrder) {
       this.hireOrder = hireOrder;
    }

    public void printPersonCard(){
        System.out.println("Информация и сотрудинке: ");
        System.out.println("1. ФИО: " + this.F_I_O);
        System.out.println("2. Должность: " + this.position);
        System.out.println("3. E-Mail: " + this.eMail);
        System.out.println("4. Tel: " + this.tel);
        System.out.println("5. Размер З.П.: " + this.salary);
        System.out.println("6. Возраст: " + this.age);
        System.out.println("7. № Приказа: " + this.hireOrder);

    }
    private boolean isTel(String tel){//телелфон должен быть 11 знаков
        return tel.length() == 11;
    }

    private boolean isEMail(String eMail){//Проерка Email на знак @
        char a;
        for (int i = 0; i < eMail.length(); i++) {
            if (eMail.charAt(i) == '@') return true;
            }
        return false;
    }
    public int getAge() {
        return this.age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getHireOrder() {
        return hireOrder;
    }

    public static int getPersonNumber() {
       return personNumber;
    }


}
