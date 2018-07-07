package hello;

import java.awt.GridLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import hello.listeners.PlusButtonListenerImpl;

@SpringComponent
@UIScope
public class Calculator extends VerticalLayout {

	public TextField inputTF1 = new TextField("Input1");
	public TextField inputTF2 = new TextField("Input2");
	public TextField outputTF = new TextField("output");

	public Calculator() {

		Button plus = new Button("+");
		Button minus = new Button("-");
		Button multiply = new Button("*");
		Button div = new Button("/");
		Button equal = new Button("=");

		HorizontalLayout buttonLine = new HorizontalLayout();
		buttonLine.add(plus, minus, multiply, div, equal);

		add(inputTF1, inputTF2, outputTF);
		Calculator currentInstance = this;

		add(plus, minus, multiply, div, equal);
		plus.addClickListener(new PlusButtonListenerImpl(currentInstance));

	}

	public int getintInput1() {
		String StringInput1 = inputTF1.getValue();
		return Integer.parseInt(StringInput1);

	}

	public int getintInput2() {
		String StringInput2 = inputTF2.getValue();
		return Integer.parseInt(StringInput2);
	}

}
