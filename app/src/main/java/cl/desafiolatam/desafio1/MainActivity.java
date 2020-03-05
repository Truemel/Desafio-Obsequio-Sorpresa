package cl.desafiolatam.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    public TextView header;
    @BindView(R.id.imageViewLeft)
    public ImageView left;
    @BindView(R.id.imageViewCenter)
    public ImageView center;
    @BindView(R.id.imageViewRight)
    public ImageView right;
    @BindView(R.id.imageViewResult)
    public ImageView result;
    @BindView(R.id.button)
    public Button button;

    @OnClick({R.id.imageViewLeft, R.id.imageViewCenter, R.id.imageViewRight})
    public void answer(){
        giveGift();
        result.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        right.setEnabled(false);
        center.setEnabled(false);
        left.setEnabled(false);
    }

    @OnClick(R.id.button)
    public void next(){
        header.setText(R.string.welcome);
        result.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        right.setEnabled(true);
        center.setEnabled(true);
        left.setEnabled(true);
    }

    private List<Integer> gifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        giftsGen();
    }

    private void giveGift(){
        int g = 0;
        result.setImageResource(gifts.get(g = ((int)(Math.random()*gifts.size()))));
        String mens = "Felicidades! ganaste";
        if(g == 0)
            mens += " una playa!";
        else if(g == 1)
            mens += " música!";
        else if(g == 2)
            mens += " un trozo de pizza!";
        else if(g == 3)
            mens += " un tren!";
        else if(g == 4)
            mens += " un maletín!";
        else if(g == 5)
            mens += " un esclavo!";
        header.setText(mens);
    }

    private void giftsGen(){
        gifts = new ArrayList<>();
        gifts.add(R.drawable.ic_gift_beach);
        gifts.add(R.drawable.ic_gift_music);
        gifts.add(R.drawable.ic_gift_pizza);
        gifts.add(R.drawable.ic_train_red_24dp);
        gifts.add(R.drawable.ic_work_blue_24dp);
        gifts.add(R.drawable.ic_slave_24dp);
    }
}
