import com.google.gson.Gson;

public class Parser <T>{
    private Gson gson = new Gson ();

    public void toJson(T t) {
        gson.toJson(t);
    }

    public T fromJson(String s, Class<T> type) {
        return gson.fromJson(s, type);
    }

}
