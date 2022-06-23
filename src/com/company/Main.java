package com.company;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner user_choice = new Scanner(System.in);
        System.out.println("Digite a data do evento:");
        String selected_date = user_choice.nextLine();
        System.out.println("Digite o numero de caes Grandes ");
        String caes_grandes = user_choice.nextLine();
        System.out.println("Digite o numero de caes Pequenos ");
        String caes_pequenos = user_choice.nextLine();

        Petshop CaninoFeliz = new MeuCaninoFeliz(isFinal_de_semana(selected_date));
        Petshop VaiRex      = new VaiRex(isFinal_de_semana(selected_date));
        Petshop ChowChawgas = new ChowChawgas();


        ArrayList<Petshop> petshops = new ArrayList<>();
        petshops.add(CaninoFeliz);
        petshops.add(VaiRex);
        petshops.add(ChowChawgas);

        CalculaValorTotal(petshops,Integer.parseInt(caes_grandes),Integer.parseInt(caes_pequenos));
    }

    static void CalculaValorTotal(List<Petshop> petshops,int caes_grandes, int caes_pequenos){

         for (Petshop petshop : petshops) {
            petshop.setPrecoTotal(caes_grandes,caes_pequenos);
        }
        petshops.sort(Comparator.comparing(Petshop::getPrecoTotal).thenComparing(Petshop::getDistancia_km));

        System.out.println("O melor Petshop é " + petshops.get(0).getNome() + ", com preço igual a R$"+ petshops.get(0).getPrecoTotal());
    }

    static boolean isFinal_de_semana(String data) {
        boolean isdia_semana;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        DayOfWeek dow = date.getDayOfWeek();
        String output = dow.getDisplayName(TextStyle.FULL, Locale.US);

        isdia_semana = output.equals("Saturday") || output.equals("Sunday");
        return isdia_semana;
    }
}
