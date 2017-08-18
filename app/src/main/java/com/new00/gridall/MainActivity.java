package com.new00.gridall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    GridView g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g= (GridView) findViewById(R.id.grid);
        g.setAdapter(new gridall(this));
        g.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this,MyDialog.class);//name of the java file of the next activity, Main2Activity
        gridall.ViewHolder  holder= (gridall.ViewHolder) view.getTag();
        single_item temp= (single_item) holder.myCountry.getTag();

        intent.putExtra("countryImage",temp.imageid);
        intent.putExtra("countryName",temp.countryname);

        startActivity(intent);
        Log.d("Yash","Dialogue box closes");
    }
}
class single_item
{
    int imageid;
    String countryname;
    single_item(int imageid,String countryname)
    {
        this.imageid=imageid;
        this.countryname=countryname;
    }
}
class gridall extends BaseAdapter
{
    Context context;
    ArrayList<single_item> list;
    gridall(Context context)
    {
        this.context =context;
        list=new ArrayList<single_item>();
        Resources res=context.getResources();

        String[] tempCountryNames=res.getStringArray(R.array.countries);

        int[] countryimages={R.drawable.germanyflag,R.drawable.brazilflag,R.drawable.france,
                R.drawable.india,R.drawable.liberiaflag,R.drawable.ukflag,R.drawable.malaysiaflag,
                R.drawable.pakistanflag,R.drawable.qatarflag,R.drawable.scotlandflag,R.drawable.srilankanflag,
                R.drawable.thailand,R.drawable.uaeflag,R.drawable.afganistanflag,R.drawable.myanmarflag,
                R.drawable.northkoreanflag,R.drawable.portugalflag,R.drawable.southkorean,R.drawable.spainflag,
                R.drawable.italyflag,R.drawable.australianflag};

        for(int i=0;i<21;i++)
        {
            single_item tempCountry=new single_item(countryimages[i],tempCountryNames[i]);
            list.add(tempCountry);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewHolder
    {
        ImageView myCountry;
        ViewHolder(View v)
        {
            myCountry= (ImageView) v.findViewById(R.id.image);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row= convertView;

        ViewHolder holder =null;
        if(row ==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.layout_item,parent,false);

            holder = new ViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        single_item temp=list.get(position);
        holder.myCountry.setImageResource(temp.imageid);
        holder.myCountry.setTag(temp);
        return row;
    }
}
