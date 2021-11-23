package com.example.digitallibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Notes> notesInfo;
    RecyclerView recView1,recView2,recView3,recView4;
    RecyclerView.LayoutManager layoutManager1,layoutManager2,layoutManager3,layoutManager4;
    NotesAdapter adapter1,adapter2,adapter3,adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCard();
        buildRecyclerView();

        createCard1();
        buildRecyclerView1();

        createCard2();
        buildRecyclerView2();

        createCard3();
        buildRecyclerView3();
    }

    public void createCard(){

        notesInfo = new ArrayList<>();

        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Test",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));

    }

    public void createCard1(){

        notesInfo = new ArrayList<>();

        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Test1 Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));

    }

    public void createCard2(){

        notesInfo = new ArrayList<>();

        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Exam Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));

    }

    public void createCard3(){

        notesInfo = new ArrayList<>();

        notesInfo.add(new Notes("Developments Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
        notesInfo.add(new Notes("Other Leading to the Bohr’s Model of Atom",R.drawable.ic_lecture_notes));
    }

    public void buildRecyclerView(){

        recView1 = findViewById(R.id.recView1);
        recView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView1.setLayoutManager(layoutManager1);
        adapter1 = new NotesAdapter(notesInfo);
        recView1.setAdapter(adapter1);

    }

    public void buildRecyclerView1(){
        recView2 = findViewById(R.id.recView2);
        recView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView2.setLayoutManager(layoutManager2);
        adapter2 = new NotesAdapter(notesInfo);
        recView2.setAdapter(adapter2);

    }

    public void buildRecyclerView2(){

        recView3 = findViewById(R.id.recView3);
        recView3.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView3.setLayoutManager(layoutManager3);
        adapter3 = new NotesAdapter(notesInfo);
        recView3.setAdapter(adapter3);
    }

    public void buildRecyclerView3(){

        recView4 = findViewById(R.id.recView4);
        recView4.setHasFixedSize(true);
        layoutManager4 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView4.setLayoutManager(layoutManager4);
        adapter4 = new NotesAdapter(notesInfo);
        recView4.setAdapter(adapter4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_menu,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);
                adapter2.getFilter().filter(newText);
                adapter3.getFilter().filter(newText);
                adapter4.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }
}