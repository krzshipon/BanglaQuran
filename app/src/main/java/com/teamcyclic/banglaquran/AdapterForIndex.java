package com.teamcyclic.banglaquran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForIndex extends BaseAdapter {
    private static LayoutInflater layoutInflater;

    Context context;
    ArrayList<String> surahList;
    //
    String adapterForWho;

    public AdapterForIndex(Context context,ArrayList<String> strings,String adapterForWho) {
        this.adapterForWho=adapterForWho;
        this.context=context;
        this.surahList=strings;

        layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    // View lookup cache
    private static class ViewHolder {
        ImageView imageView_book;
        TextView txtNameEng;
        TextView txtNameBng;
        TextView txtNameTotalVerse;
        ImageView imageView_play;

        //
        TextView txtAllahNameAra;
        TextView txtAllahNameBng;
        TextView txtAllahNameBngM;
        TextView txtAllahNameEngM;



    }

    @Override
    public int getCount() {
        return surahList.size();
    }

    @Override
    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(adapterForWho.equalsIgnoreCase("SurahIndex")){
            // Get the data item for this position
             String  infoSura=surahList.get(position);

         StringBuilder stringBuilder=new StringBuilder(infoSura);
         String [] sigleInfoOfASura=stringBuilder.toString().split("#");
        // Check if an existing view is being reused, otherwise inflate the view
        AdapterForIndex.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new AdapterForIndex.ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            viewHolder.imageView_book=convertView.findViewById(R.id.imageViewBooklogo_index);
            viewHolder.txtNameBng = (TextView) convertView.findViewById(R.id.textView_suranameBangla);
            viewHolder.txtNameEng=(TextView) convertView.findViewById(R.id.textView_suraNameEng);
            viewHolder.txtNameTotalVerse=(TextView) convertView.findViewById(R.id.textView_totalVerse);
            viewHolder.imageView_play=convertView.findViewById(R.id.imageViewPlaylogo_index);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterForIndex.ViewHolder) convertView.getTag();
            result=convertView;
        }


        //lastPosition = position;
        // 0->surah# 1->uB 2->according to nazil no   3->totalverse 4->bang 5->arabic 6->uE 7->eng 8->location 9->para 10->first ayah 11->ruku 12->sizdah
        viewHolder.imageView_book.setImageResource(R.drawable.logo_book_open);
        String s1=sigleInfoOfASura[0]+". "+sigleInfoOfASura[1];
        viewHolder.txtNameBng.setText(s1);
        viewHolder.txtNameEng.setText(sigleInfoOfASura[6]);
        String s="Total Verse: "+sigleInfoOfASura[3];
        viewHolder.txtNameTotalVerse.setText(s);
        viewHolder.imageView_play.setImageResource(R.drawable.logo_play);
        }else {


            // Get the data item for this position
            String  infoName=surahList.get(position);

            StringBuilder stringBuilder=new StringBuilder(infoName);
            String [] sigleInfoOfAName=stringBuilder.toString().split("@");
            // Check if an existing view is being reused, otherwise inflate the view
            AdapterForIndex.ViewHolder viewHolder; // view lookup cache stored in tag

            final View result;

            if (convertView == null) {

                viewHolder = new AdapterForIndex.ViewHolder();
                convertView = layoutInflater.inflate(R.layout.list_item_allhname, parent, false);
                //
                viewHolder.txtAllahNameAra= (TextView) convertView.findViewById(R.id.textView6_n_arabicName);
                viewHolder.txtAllahNameBng = (TextView) convertView.findViewById(R.id.textView7_n_bangla);
                viewHolder.txtAllahNameBngM=(TextView) convertView.findViewById(R.id.textView8_n_banglaMeaning);
                viewHolder.txtAllahNameEngM=(TextView) convertView.findViewById(R.id.textView9_n_engMeaning);

                result=convertView;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (AdapterForIndex.ViewHolder) convertView.getTag();
                result=convertView;
            }


            //lastPosition = position;
            //
            viewHolder.txtAllahNameAra.setText(sigleInfoOfAName[1]);

            viewHolder.txtAllahNameBng.setText(sigleInfoOfAName[0]);

            viewHolder.txtAllahNameBngM.setText(sigleInfoOfAName[2]);

            viewHolder.txtAllahNameEngM.setText(sigleInfoOfAName[3]);





        }
        // Return the completed view to render on screen
        return convertView;
    }
}
