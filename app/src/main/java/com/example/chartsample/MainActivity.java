package com.example.chartsample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HorizontalBarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Muda o título no topo da tela
        setTitle("Gráfico de Barras Horizontal");

        // Pega a referencia do gráfico no layout
        chart = findViewById(R.id.chart1);





        // Algumas configurações do gráfico,
        // não sei detalhadamente o que cada uma faz
        // mas o nome do metodo da uma sugestão (parte estética apenas)
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setMaxVisibleValueCount(60);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);


        // Configura o Eixo X do gráfico (parte estética apenas)
        XAxis xl = chart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setTypeface(Typeface.DEFAULT);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(10f);


        // Configura o Eixo Y do gráfico (parte estética apenas)
        YAxis yl = chart.getAxisLeft();
        yl.setTypeface(Typeface.DEFAULT);
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f);

        // Configura o lado direito do gráfico (parte estética apenas)
        YAxis yr = chart.getAxisRight();
        yr.setTypeface(Typeface.DEFAULT);
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f);
        chart.setFitBars(true);
        chart.animateY(2500);

        // Configura a legenda do gráfico
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);



        // Aqui o gráfico é feito, parte mais importante
        setData();




    }



    // Aqui sim é importante, esse método que vai construir o gráfico, antes apenas definiamos questoes estéticas
    private void setData() {

        float barWidth = 5f;
        float spaceForBar = 10f;

        // Uma bar entry consiste em uma barra no grafico, então criaremos um array de barras;
        ArrayList<BarEntry> values = new ArrayList<>(); // Lista de objetos do tipo BarEntry



        values.add(new BarEntry(0f*spaceForBar, 40)); // Adicionando a barra a nossa lista de barras
        values.add(new BarEntry(1f*spaceForBar, 80)); // Essa *spaceForBar serve para dar espaço entre as barras
        values.add(new BarEntry(2f*spaceForBar, 30)); // vc só muda o valor do segundo input que é o tamanho da barra
        values.add(new BarEntry(3f*spaceForBar, 20)); // o primeiro input deve começar com 0 e ir crescendo (tem que por o f pra converter para Float de maneira implicita)
        values.add(new BarEntry(4f*spaceForBar, 35));



        // Um BarDataSet é um objeto que armazena uma lista de barras e nomeia esse grupo
        BarDataSet set1;

        // armazenando nossa lista de barras no objeto BarDataSet set1
        set1 = new BarDataSet(values, "DataSet 1");


        set1.setDrawIcons(false); // connfigurando o set1 (estética)

        // Precisamos de uma lista de sets, no nosso caso só temos um mas poderia ter varios.
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        // FINALMENTE chegamos ao objeto BarData que é jogado direto no gráfico

        BarData data = new BarData(dataSets);
        // configurando o BarData (estética)
        data.setValueTextSize(10f);
        data.setValueTypeface(Typeface.DEFAULT);
        data.setBarWidth(barWidth);

        /* Resumindo:

             Como vamos trabalhar com casos simples no inicio,

             vc precisa apenas dar um jeito de criar as BarEntrys de acordo com a informação que quer exibir

             e depois é so sequir o que o codigo faz


        * */




        chart.setData(data);

    }




}
