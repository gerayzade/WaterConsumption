package gerayzade.waterconsumption;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends Activity {
    public TextView cupsperday;
    public int kilos;
    public TextView litresperday;
    public TextView mass;
    public SeekBar seekbarMass;

    public class updateMass implements OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekbarMass, int massValue, boolean fromUser) {
            MainActivity.this.kilos = massValue + 20;
            MainActivity.this.mass.setText(MainActivity.this.kilos + " kg");
            double ounces = (((double) MainActivity.this.kilos) / 0.453592d) / 2.0d;
            int cups = ((int) ounces) / 8;
            MainActivity.this.litresperday.setText(new BigDecimal(ounces / 33.814d).setScale(1, RoundingMode.UP).doubleValue() + " L / DAY");
            MainActivity.this.cupsperday.setText("or " + cups + " cups of water");
        }

        public void onStartTrackingTouch(SeekBar seekbarMass) {
        }

        public void onStopTrackingTouch(SeekBar seekbarMass) {
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.seekbarMass = (SeekBar) findViewById(R.id.seekbar_mass);
        this.mass = (TextView) findViewById(R.id.mass);
        this.litresperday = (TextView) findViewById(R.id.litresperday);
        this.cupsperday = (TextView) findViewById(R.id.cups);
        this.seekbarMass.setOnSeekBarChangeListener(new updateMass());
    }
}