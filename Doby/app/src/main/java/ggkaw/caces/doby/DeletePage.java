package ggkaw.caces.doby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;

public class DeletePage extends AppCompatActivity {

    CourseWrapper cwrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_page);

        String[] courseNames = getIntent().getStringArrayExtra("Course Names");
        Spinner s = (Spinner) findViewById(R.id.Course_Assign_Spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void deleteCourse(View view) {
        // get coursename from dropdown and delete it using the delete the delete function
        Spinner s = (Spinner) findViewById(R.id.Course_Assign_Spin);
        String courseName = s.getSelectedItem().toString();
        cwrap = new CourseWrapper((CourseWrapper) getIntent().getSerializableExtra("Course Wrapper"));
        cwrap.deleteCourse(courseName);
    }


    public void launchDone(View view) {
        Intent sendNewWrapper = new Intent(this, HomePage.class);
        //CourseWrapper cwrap = (CourseWrapper) sendNewWrapper.getSerializableExtra("Course Wrapper");

        sendNewWrapper.putExtra("Flag", "Course Deleted");
        sendNewWrapper.putExtra("CourseWrap", cwrap); // Passing course class from this page to home page ...
        startActivity(sendNewWrapper);
    }
}

