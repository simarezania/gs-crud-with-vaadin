package hello;

import java.awt.GridLayout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
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
	
	int base=5;

	public TextField inputTF1 = new TextField("Input1");
	public TextField inputTF2 = new TextField("Input2");
	public TextField outputTF = new TextField("output");

	public Calculator() {

		Button plus = new Button("+");
		Button minus = new Button("-");
		Button multiply = new Button("*");
		Button div = new Button("/");
		Button remain =new Button ("%");

		HorizontalLayout buttonLine = new HorizontalLayout();
		buttonLine.add(plus, minus, multiply, div, remain);

		add(inputTF1, inputTF2, outputTF);
		Calculator currentInstance = this;

		add(plus, minus, multiply, div, remain);
		plus.addClickListener(new PlusButtonListenerImpl(this));
		minus.addClickListener(new MinusButtonListenerImpl());
		remain.addClickListener(e->this.outputTF.setValue(Integer.toString(this.getIntInput1() % this.getIntInput2())));
		
		div.addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				outputTF
						.setValue(Integer.toString(Calculator.this.getIntInput1() / Calculator.this.getIntInput2()));
			}

		});
		
		// inner class in method
		
		class MultiplyButtonListenerImpl implements ComponentEventListener {

			public void onComponentEvent(ComponentEvent event) {
				outputTF
						.setValue(Integer.toString(Calculator.this.getIntInput1() * Calculator.this.getIntInput2()));
			}
		}
		
		multiply.addClickListener(new MultiplyButtonListenerImpl());
	}

	public int getIntInput1() {
		String StringInput1 = inputTF1.getValue();
		return Integer.parseInt(StringInput1);

	}

	public int getIntInput2() {
		String StringInput2 = inputTF2.getValue();
		return Integer.parseInt(StringInput2);
	}

	// inner class
	
	class MinusButtonListenerImpl implements ComponentEventListener {
		int innerClass=7;

		public void onComponentEvent(ComponentEvent event) {
			outputTF
					.setValue(Integer.toString(Calculator.this.getIntInput1() - Calculator.this.getIntInput2()));
		}
	}

}
