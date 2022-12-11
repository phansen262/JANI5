package com.stickware.jani5.gui.library.components.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MRevAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /** How to properly use this class at location
     *
     *     mBinding.rev view id.setAdapter(new MRevAdapter(list.length, (inflater, parent, viewType) ->
     *
     *             Below line is for one line lambda expression, expand to multiple lines with if statements you have multiple viewTypes
     *
     *             new MRevAdapter.ViewHolder(RevitemEquipmentModelBinding.inflate(inflater, parent, false)), (binding, position) -> {
     *
     *             Insert code to be run on bind view holder here
     *     }));
     */

    //Interfaces to be used within code
    @FunctionalInterface
    public interface GetViewHolder {
        RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType);
    }

    @FunctionalInterface
    public interface SetDisplay {
        void setDisplay(ViewDataBinding binding, int position);
    }

    //Reference object list
    //TODO: Make this private and add access methods?
    public ArrayList<?> mItems;
    //Interface objects for internal use
    private final GetViewHolder getViewHolder;
    private final SetDisplay setDisplay;


    public MRevAdapter(ArrayList<?> items, GetViewHolder getViewHolder, SetDisplay setDisplay){
        this.mItems = items;
        this.getViewHolder = getViewHolder;
        this.setDisplay = setDisplay;
    }

    //Need to call before asking adapter to update
    public void updateItemList(ArrayList<?> newList){mItems = newList;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return getViewHolder.getViewHolder(layoutInflater, parent, viewType);
    }

    //Code gets inserted from second interface here
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){

        ViewHolder vh1 = (ViewHolder) holder;
        vh1.mBinding.executePendingBindings();
        setDisplay.setDisplay(vh1.mBinding, position);
    }

    //Sets the type to be same as position. Binding will be handled uniquely for each item anyway, need to still include
    //so that position is returned as a parameter
    @Override
    public int getItemViewType(int position){
        return position;
    }

    //Set list size
    @Override
    public int getItemCount(){return mItems.size();}

    //Interior subclass for setting up binding
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewDataBinding mBinding;

        public ViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
