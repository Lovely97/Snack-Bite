package com.example.booking;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    NumberPicker beverages,snacks_list;
    String[] possibilitiesStrings = {
            "Select",
            "Tea",
            "Coffee",
            "Water",
            "Mangoshake",
            "Buttermilk"
    };
    String[] possibilitiesSnacks = {
            "Select",
            "Samosa",
            "Idli",
            "Dosa",
            "Vada",
            "Bread Pakora",
            "French Fries",
            "Burger",
            "Uttapam"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        beverages = (NumberPicker) findViewById(R.id.beverage_id);
        snacks_list=(NumberPicker) findViewById(R.id.snack_id);
        beverages.setDisplayedValues(possibilitiesStrings);
        beverages.setMinValue(0);
        beverages.setMaxValue(possibilitiesStrings.length - 1);
        snacks_list.setDisplayedValues(possibilitiesSnacks);
        snacks_list.setMinValue(0);
        snacks_list.setMaxValue(possibilitiesSnacks.length - 1);

    }

    public void Sendmessage(View v)
    {
        int choice1=snacks_list.getValue();
        int choice2=beverages.getValue();
        String message1="Order from Table No. ";
        String message=((EditText)(findViewById(R.id.Textbox1))).getText().toString();
        if(choice1!=0)
            message=message+"\n"+possibilitiesSnacks[choice1];
        if(choice2!=0)
            message=message+"\n"+possibilitiesStrings[choice2];
        message1= message1+message;
        if(choice1!=0 || choice2!=0) {
            Uri destination = Uri.parse("smsto:0000");
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
            smsIntent.putExtra("sms_body", message1);
            startActivity(smsIntent);
        }

    }
}