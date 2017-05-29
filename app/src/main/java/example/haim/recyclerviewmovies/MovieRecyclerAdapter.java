package example.haim.recyclerviewmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL e7440 on 25/05/2017.
 */

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    private final Context context;
    List<Movie> movies = MovieDataSource.getMovies();
    private LayoutInflater inflater;

    public MovieRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    //Create an instance of MovieViewHolder and return it.
    //take an xml convert to a view -> use the inflater.
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = inflater.inflate(R.layout.movie_item, parent, false);
        MovieViewHolder holder = new MovieViewHolder(v);
        return holder;
        //or : return new MovieViewHolder(v);
    }

    //Data Binding - Depends on the screen size this methode addapt the items to the view holder
    @Override
    public void onBindViewHolder(MovieViewHolder h, int position) {
        Movie m = movies.get(position);
        h.tvTitle.setText(m.getTitle());
        h.tvRating.setText(String.valueOf(m.getRating()));
        h.ivThumbnail.setImageResource(m.getThumbnailResId());

        String[] genres = m.getGenres();
        String s = Arrays.toString(genres);
        h.tvGenre.setText(s);

        h.tvYear.setText(String.valueOf(m.getYear()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{


        TextView tvTitle, tvGenre, tvRating, tvYear;
        ImageView ivThumbnail;


        public MovieViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvGenre = (TextView) v.findViewById(R.id.tvGenre);
            tvRating = (TextView) v.findViewById(R.id.tvRating);
            tvYear = (TextView) v.findViewById(R.id.tvYear);
            ivThumbnail = (ImageView) v.findViewById(R.id.ivThumbnail);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getAdapterPosition();
                    Toast.makeText(context,  movies.get(p).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }




    }


}
