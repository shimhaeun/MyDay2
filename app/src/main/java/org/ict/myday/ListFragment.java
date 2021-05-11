package org.ict.myday;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.ict.myday.retrofit_test.BoxOfficeResult;
import org.ict.myday.retrofit_test.Example;
import org.ict.myday.retrofit_test.RetrofitClient;
import org.ict.myday.retrofit_test.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    RecyclerView listRecycler;
    RecyclerView.Adapter lAdapter;
    LinearLayoutManager manager;

    // ajax호출을 위한 Retrofit 관련 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 발급받은 API 키
    private String API_KEY = "eb9baa93c7c942cfaf7191f68b9b9455";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        initView(rootView);
        setRecycler();

        return rootView;
    }

    public void initView(View v){
        listRecycler = (RecyclerView) v.findViewById(R.id.listRecycler);
    }

    private void setRecycler(){
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listRecycler.setLayoutManager(manager);
        // 레트로핏 객체를 생성해 DB와 통신 준비 완료
        retrofitClient = RetrofitClient.getInstance();

        // 레트로핏 인터페이스를 생성해 DB와 통신시 요청할 메서드 준비 완료
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        //$.ajax에 대응하는 레트로핏 문법 작성합니다.
        retrofitInterface.getBoxOffice(API_KEY,"20210505").enqueue(new Callback<Example>() {

            // 요청이 전달되었을 경우 처리할 내용은 onResponse 메서드를 오버라이드해 만듭니다.
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                // 응답객체의 body 부분에 json 데이터가 존재함
                Example example = response.body();
                BoxOfficeResult boxOfficeResult = example.getBoxOfficeResult();
                // boxOffice 데이터 중 영화 정보만 빼 온 다음, 어댑터 객체를 생성할 때 사용
                lAdapter = new ListAdapter(boxOfficeResult.getDailyBoxOfficeList());

                // 리사이클러 뷰에 어댑터 적용
                listRecycler.setAdapter(lAdapter);
            }

            // 요청 자체가 서버에 들어가지 않으면 발생하는 오류(400)
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(),"호출 실패",Toast.LENGTH_SHORT).show();
            }
        });
    }


}