package com.geek.remotecontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class RemoteControlFragment extends Fragment {

    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote_control, container, false);
        mSelectedTextView = (TextView) view.findViewById(R.id
                .fragment_remote_control_selectedTextView);
        mWorkingTextView = (TextView) view.findViewById(R.id
                .fragment_remote_control_workingTextView);

        View.OnClickListener numberButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                String working = mWorkingTextView.getText().toString();
                String text = tv.getText().toString();
                if (working.equals("0")) {
                    mWorkingTextView.setText(text);
                } else {
                    mWorkingTextView.setText(working + text);
                }
            }
        };

//        Button zeroButton = (Button) view.findViewById(R.id.fragment_remote_control_zeroButton);
//        zeroButton.setOnClickListener(numberButtonListener);
//
//        Button oneButton = (Button) view.findViewById(R.id.fragment_remote_control_oneButton);
//        oneButton.setOnClickListener(numberButtonListener);

        TableLayout tbLayout = (TableLayout) view.findViewById(R.id
                .fragment_remote_control_table_layout);
        int number = 1;

        // index in fragment_remote_control.xml : 0 : textview selected; 1 : textview working,
        // table row include start at index 2
        for (int i = 2; i < tbLayout.getChildCount() - 1; i++) {
            TableRow row = (TableRow) tbLayout.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                Button btn = (Button) row.getChildAt(j);
                btn.setText("" + number++);
                btn.setOnClickListener(numberButtonListener);
            }
        }

        TableRow bottomRow = (TableRow) tbLayout.getChildAt(tbLayout.getChildCount() - 1);
        Button deleteButton = (Button) bottomRow.getChildAt(0);
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWorkingTextView.setText("0");
            }
        });
        deleteButton.setTextAppearance(getContext(), R.style.ActionRemoteButton);

        Button zeroButton = (Button) bottomRow.getChildAt(1);
        zeroButton.setText("0");
        zeroButton.setOnClickListener(numberButtonListener);


        Button enterButton = (Button) bottomRow.getChildAt(2);
        enterButton.setText("Enter");
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = mWorkingTextView.getText();
                if (text.length() > 0) {
                    mSelectedTextView.setText(text);
                }
                mWorkingTextView.setText("0");
            }
        });
        enterButton.setTextAppearance(getContext(), R.style.ActionRemoteButton);
        return view;
    }
}
