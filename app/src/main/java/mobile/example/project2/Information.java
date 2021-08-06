package mobile.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Information extends AppCompatActivity {

    EditText etName, etEmail, etComments, etLocation, etCoordinate;
    RequestQueue queue;
    final String URL = "http://192.168.230.39/tracker/api.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        queue = Volley.newRequestQueue(getApplicationContext());

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etComments = (EditText) findViewById(R.id.etComments);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etCoordinate= (EditText) findViewById(R.id.etCoordinate);


        Button button = (Button) findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //volley call

                makeRequest();
            }
        });

    }

    public void makeRequest() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, errorListener){
            @Override
            protected Map<String,String> getParams() {
                Map <String, String> params = new HashMap<>();

                params.put("name", etName.getText().toString());
                params.put("email", etEmail.getText().toString());
                params.put("comments",etComments.getText().toString());
                params.put("location",etLocation.getText().toString());
                params.put("coordinate",etCoordinate.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);
    }

    public Response.ErrorListener errorListener= new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

        }
    };
}