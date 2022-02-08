package JavaFX01_SimpleCal;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
public class SimpleCalc extends Application {
    
        VBox main_1 = new VBox();
        TextField main_2 = new TextField();
        Button [] main_2a = 
        {
            new Button("CE"),
            new Button("C"),
            new Button("Back"),
            new Button("/"),
            new Button("7"),
            new Button("8"),
            new Button("9"),
            new Button("*"),
            new Button("4"),
            new Button("5"),
            new Button("6"),
            new Button("-"),
            new Button("1"),
            new Button("2"),
            new Button("3"),
            new Button("+"),
            new Button("0"),
            new Button("."),
            new Button("=")
        };
        
        GridPane main_22 = new GridPane();
        
        String [] term = new String [100];
        String [] ops = new String[99];
        int cterm = 0;
        int cops = 0;
        int isRestart = 0;
        String lastInsert = "";
        
    @Override
    public void start(Stage main) {
        for(int h = 0; h < 100; h++)
            term[h] = "";
        
        for(int h = 0; h < 99; h++)
            ops[h] = "";
        
        main_2a[0].setMinWidth(50); 
        main_2a[0].setMinHeight(50);
        main_2a[1].setMinWidth(50); 
        main_2a[1].setMinHeight(50);
        main_2a[2].setMinWidth(50); 
        main_2a[2].setMinHeight(50);
        main_2a[3].setMinWidth(50); 
        main_2a[3].setMinHeight(50);
        main_2a[4].setMinWidth(50); 
        main_2a[4].setMinHeight(50);
        main_2a[5].setMinWidth(50); 
        main_2a[5].setMinHeight(50);
        main_2a[6].setMinWidth(50); 
        main_2a[6].setMinHeight(50);
        main_2a[7].setMinWidth(50); 
        main_2a[7].setMinHeight(50);
        main_2a[8].setMinWidth(50); 
        main_2a[8].setMinHeight(50);
        main_2a[9].setMinWidth(50); 
        main_2a[9].setMinHeight(50);
        main_2a[10].setMinWidth(50); 
        main_2a[10].setMinHeight(50);
        main_2a[11].setMinWidth(50); 
        main_2a[11].setMinHeight(50);
        main_2a[12].setMinWidth(50); 
        main_2a[12].setMinHeight(50);
        main_2a[13].setMinWidth(50); 
        main_2a[13].setMinHeight(50);
        main_2a[14].setMinWidth(50); 
        main_2a[14].setMinHeight(50);
        main_2a[15].setMinWidth(50); 
        main_2a[15].setMinHeight(50);
        main_2a[16].setMinWidth(50); 
        main_2a[16].setMinHeight(50);
        main_2a[17].setMinWidth(50); 
        main_2a[17].setMinHeight(50);
        main_2a[18].setMinWidth(50); 
        main_2a[18].setMinHeight(50);
        
        main_22.add(main_2a[0],0,0); 
        main_22.add(main_2a[1],1,0); main_22.add(main_2a[2],2,0); main_22.add(main_2a[3],3,0);
        main_22.add(main_2a[4],0,1); main_22.add(main_2a[5],1,1); main_22.add(main_2a[6],2,1); main_22.add(main_2a[7],3,1);
        main_22.add(main_2a[8],0,2); main_22.add(main_2a[9],1,2); main_22.add(main_2a[10],2,2); main_22.add(main_2a[11],3,2);
        main_22.add(main_2a[12],0,3); main_22.add(main_2a[13],1,3); main_22.add(main_2a[14],2,3); main_22.add(main_2a[15],3,3);
        main_22.add(main_2a[16],1,4); main_22.add(main_2a[17],2,4); main_22.add(main_2a[18],3,4);
        
        main_1.getChildren().addAll(main_2,main_22);
        
        main_2a[0].setOnAction(e -> clearCalc());
        main_2a[1].setOnAction(e -> clearCalc());
        main_2a[2].setOnAction(e -> clearOne());
        main_2a[3].setOnAction(e -> addOne(main_2a[3].getText()));
        main_2a[4].setOnAction(e -> addOne(main_2a[4].getText()));
        main_2a[5].setOnAction(e -> addOne(main_2a[5].getText()));
        main_2a[6].setOnAction(e -> addOne(main_2a[6].getText()));
        main_2a[7].setOnAction(e -> addOne(main_2a[7].getText()));
        main_2a[8].setOnAction(e -> addOne(main_2a[8].getText()));
        main_2a[9].setOnAction(e -> addOne(main_2a[9].getText()));
        main_2a[10].setOnAction(e -> addOne(main_2a[10].getText()));
        main_2a[11].setOnAction(e -> addOne(main_2a[11].getText()));
        main_2a[12].setOnAction(e -> addOne(main_2a[12].getText()));
        main_2a[13].setOnAction(e -> addOne(main_2a[13].getText()));
        main_2a[14].setOnAction(e -> addOne(main_2a[14].getText()));
        main_2a[15].setOnAction(e -> addOne(main_2a[15].getText()));
        main_2a[16].setOnAction(e -> addOne(main_2a[16].getText()));
        main_2a[17].setOnAction(e -> addOne(main_2a[17].getText()));
        main_2a[18].setOnAction(e -> equalPressed());
        
        Scene sc = new Scene(main_1);
        main.setScene(sc);
        main.setTitle("winlikecalc");
        main.show();
    }
    
    private void clearCalc()
    {
        main_2.setText("");
        for(int h = 0; h < 5; h++)
            term[h] = "";
        
        for(int h = 0; h < 4; h++)
            ops[h] = "";
        
        cops = cterm = 0;
    }
    
    private void clearOne()
    {
        if(isRestart == 0)
        {
            String ramp = main_2.getText();
            if(ramp.length()!=0)
            {
            String tremp = ramp.substring(ramp.length()-1);
            ramp = ramp.substring(0,ramp.length()-1);
            main_2.setText(ramp);

            if(tremp.equals("+")||tremp.equals("-")||tremp.equals("*")||tremp.equals("/"))
            {
                ops[cops-1] = "";
                cops -= 1;
                if(cops == -1)
                    cops = 0;
                System.out.println("After operator deletion: "+ ops[0]+ " " +ops[1]+ " " +ops[2]+ " " +ops[3]);
            }
            else
            {
                if(term[cterm].length() == 1)
                {
                    term[cterm] = "";
                    cterm -= 1;
                    if(cterm == -1)
                        cterm = 0; 
                    System.out.println("After term deletion: "+term[0]+ " " +term[1]+ " " +term[2]+ " " +term[3]+ " " +term[4]);
                }
                else
                {
                    term[cterm] = term[cterm].substring(0,term[cterm].length()-1);
                    System.out.println("After term deletion: "+term[0]+ " " +term[1]+ " " +term[2]+ " " +term[3]+ " " +term[4]);
                }
            }
            }
            else
            {}
        }
    }
    
    private void addOne(String text)
    {
        if(isRestart==1)
        {
            main_2.setText("");
            isRestart = 0;
        }
        // float remp = (float) Double.parseDouble(text);
        String ramp = main_2.getText();
        ramp += text;
        if(text.equals("+")||text.equals("-")||text.equals("*")||text.equals("/"))
        {
            if(!lastInsert.equals("+")&&!lastInsert.equals("-")&&!lastInsert.equals("*")&&!lastInsert.equals("/"))
            {
                ops[cops] += text;
                cterm++;
                cops++;
                System.out.println("Number of operators: " + cops);
                System.out.println("The operators: " + ops[0]+ " " +ops[1]+ " " +ops[2]+ " " +ops[3]);
            }
            else
            {
                ramp = ramp.substring(0,ramp.length()-1);
            }
            lastInsert = text;
        }
        else
        {
            term[cterm] += text;
            lastInsert = text;
            System.out.println("Number of terms: " + (cterm + 1));
            System.out.println("The terms: " +term[0]+ " " +term[1]+ " " +term[2]+ " " +term[3]+ " " +term[4]);
        }
        main_2.setText(ramp);
    }
    
    private void equalPressed()
    {
        float temp = 0;
        if(term[0].equals(""))
            term[0] = "0";
        switch(ops[0])
            {
                case "+": temp = (float) Double.parseDouble(term[0]) + (float) Double.parseDouble(term[1]); break;
                case "-": temp = (float) Double.parseDouble(term[0]) - (float) Double.parseDouble(term[1]); break;
                case "*": temp = (float) Double.parseDouble(term[0]) * (float) Double.parseDouble(term[1]); break;
                case "/": temp = (float) Double.parseDouble(term[0]) / (float) Double.parseDouble(term[1]); break;
            }
        for(int c = 1; c < cterm; c++)
        {
            if(term[c].equals(""))
                term[c] = "0";
            switch(ops[c])
            {
                case "+": temp += (float) Double.parseDouble(term[c+1]); break;
                case "-": temp -= (float) Double.parseDouble(term[c+1]); break;
                case "*": temp *= (float) Double.parseDouble(term[c+1]); break;
                case "/": temp /= (float) Double.parseDouble(term[c+1]); break;
            }
        }
        String temp2 = temp + "";
        main_2.setText(temp2);
        
        for(int h = 0; h < 5; h++)
            term[h] = "";
        
        for(int h = 0; h < 4; h++)
            ops[h] = "";
        
        cops = cterm = 0;
        isRestart = 1;
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}
