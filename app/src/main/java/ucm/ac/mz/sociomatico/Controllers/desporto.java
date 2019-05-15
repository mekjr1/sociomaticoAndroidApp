package ucm.ac.mz.sociomatico.Controllers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ucm.ac.mz.sociomatico.Models.Model;
import ucm.ac.mz.sociomatico.Models.RecyclerViewAdapter;
import ucm.ac.mz.sociomatico.Models.RetrofitArrayApi;
import ucm.ac.mz.sociomatico.Models.WPPost;
import ucm.ac.mz.sociomatico.R;
import  ucm.ac.mz.sociomatico.Models.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link sociedade.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link sociedade#newInstance} factory method to
 * create an instance of this fragment.
 */
public class desporto extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int tamanho = 10;


    private OnFragmentInteractionListener mListener;

    public desporto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sociedade.
     */
    // TODO: Rename and change types and number of parameters
    public static desporto newInstance(String param1, String param2) {
        desporto fragment = new desporto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Model> list;
    private RecyclerViewAdapter adapter;

    private String baseURL = "http://www.sociomatico.com";

    public static List<WPPost> mListPost;
    boolean isLoading = false;
    int page = 1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_categorias, container,false);



        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        list = new ArrayList<Model>();
        /// call retrofit
        getRetrofit(page);
        page++;

        adapter = new RecyclerViewAdapter( list, view.getContext());

        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == list.size() - 1) {
                        //bottom of list!
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });








        return view;
    }





    private void loadMore() {

        if (list.get(list.size() - 1)!=null) {
            list.add(null);
            this.tamanho = list.size() - 1;
            adapter.notifyItemInserted(list.size() - 1);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    getRetrofit(page);

                    list.remove(list.size() - 1);
                    page++;

                    adapter.notifyDataSetChanged();
                    isLoading = false;


                }
            }, 10000);


        }
    }









    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }





    public void getRetrofit(final int page){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        //Call<List<WPPost>> call = service.getPostInfo();

        // to make call to dynamic URL


        Call<List<WPPost>>  call = service.getPostInfo("http://www.sociomatico.com/wp-json/wp/v2/posts?categories=140&_embed=true",page);

        call.enqueue(new Callback<List<WPPost>>() {
            @Override
            public void onResponse(Call<List<WPPost>> call, Response<List<WPPost>> response) {


                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);

                    if(page!=1) {

                        if (list.get(list.size() - 1)==null) {


                            list.remove(list.size() - 1);
                            int scrollPosition = list.size();
                            adapter.notifyItemRemoved(scrollPosition);

                        }
                    }

                    for (int i = 0; i < response.body().size(); i++) {
                        Log.e("main ", " title " + response.body().get(i).getTitle().getRendered() + " " +
                                response.body().get(i).getId());


                        String data = response.body().get(i).getDate();
                        String datadef = "";

                        for (int k = 0; k < data.length(); k++) {

                            if (data.charAt(k) != 'T') {
                                datadef = datadef + data.charAt(k);
                            } else {
                                k = 2000;
                            }

                        }


                        String tempdetails = response.body().get(i).getExcerpt().getRendered().toString();


                        try {


                            list.add(new Model(Model.IMAGE_TYPE, response.body().get(i).getTitle().getRendered(),
                                    tempdetails,
                                    response.body().get(i).getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl(),
                                    response.body().get(i).getContent().getRendered(), datadef));

                        } catch (Exception ex) {

                            list.add(new Model(Model.IMAGE_TYPE, response.body().get(i).getTitle().getRendered(),
                                    tempdetails,
                                    "https://uwosh.edu/facilities/wp-content/uploads/sites/105/2018/09/no-photo.png",
                                    response.body().get(i).getContent().getRendered(), datadef));


                        }


                    }
                    adapter.notifyDataSetChanged();

                }
            }





            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {

            }
        });

    }
    public static List<WPPost> getList(){
        return  mListPost;
    }
}













