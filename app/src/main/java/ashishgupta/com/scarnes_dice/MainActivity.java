package ashishgupta.com.scarnes_dice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView dice;
    Button hold,roll,reset;
    int userOverallScore,computerTurnScore,computerOverallScore;
    TextView userRound,userOverall,computerRound,computerOverall;
    private int userTurnScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice=(ImageView)findViewById(R.id.Dice);
        dice.setImageResource(R.drawable.one);
        hold=(Button)findViewById(R.id.hold);
        roll=(Button)findViewById(R.id.roll);
        reset=(Button)findViewById(R.id.roll);
        userRound=(TextView)findViewById(R.id.UserRoundScore);
        userOverall=(TextView)findViewById(R.id.UserOverall);
        computerRound=(TextView)findViewById(R.id.ComputerRoundScore);
        computerOverall=(TextView)findViewById(R.id.ComputerOverall);
        reset();
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.hold:hold();break;
            case R.id.roll:roll(); break;
            case R.id.reset: reset(); break;
        }
    }

    public void roll()
    {
        int i=new Random().nextInt(6)+1;
        switch (i)
        {
            case 1: dice.setImageResource(R.drawable.one);
                    userTurnScore=0;
                    userRound.setText("0");
                    break;

            case 2: dice.setImageResource(R.drawable.two);
                    userTurnScore +=2;
                    userRound.setText(String.valueOf(userTurnScore));
                     break;
            case 3:dice.setImageResource(R.drawable.three);
                     userTurnScore +=3;
                     userRound.setText(String.valueOf(userTurnScore));
                break;
            case 4:  dice.setImageResource(R.drawable.four);
                    userTurnScore +=4;
                    userRound.setText(String.valueOf(userTurnScore));
                break;
            case 5:  dice.setImageResource(R.drawable.five);
                      userTurnScore +=5;
                      userRound.setText(String.valueOf(userTurnScore));
                break;
            case 6:   dice.setImageResource(R.drawable.six);
                      userTurnScore +=6;
                userRound.setText(String.valueOf(userTurnScore));

        }

    }

    public void hold()
    {
           userOverallScore+=userTurnScore;
           userOverall.setText(String.valueOf(userOverallScore));
           userTurnScore=0;
           userRound.setText("0");
          if(userOverallScore>100)
          {
              Toast.makeText(this,"User wins",Toast.LENGTH_LONG).show();
              hold.setEnabled(false);
              roll.setEnabled(false);
              return;
          }
            computerTurn();
    }
    public void reset()
    {
        userOverallScore=0;userTurnScore=0;
        computerOverallScore=0;computerTurnScore=0;
        userRound.setText("0");
        userOverall.setText("0");
        computerOverall.setText("0");
        computerRound.setText("0");
        hold.setEnabled(true);
        roll.setEnabled(true);

    }

    public void computerTurn()
    {
        Log.e("Computer","Computer function was executed");
        computerTurnScore=0;
        int i;
        computerRound.setText("0");
        while(computerTurnScore<20)
        {
            i=new Random().nextInt(6)+1;
            Log.e("ComScore",String.valueOf(i));
            if(i==1)
            {
             computerTurnScore=0;
                computerRound.setText("0");
            }else {
                computerTurnScore += i;
                computerRound.setText(String.valueOf(computerTurnScore));
            }

        }
        computerOverallScore+=computerTurnScore;

        computerOverall.setText(String.valueOf(computerOverallScore));
         if(computerOverallScore>100)
         {
             Toast.makeText(this,"Computer wins",Toast.LENGTH_LONG).show();
             hold.setEnabled(false);
             roll.setEnabled(false);
         }

    }

}
