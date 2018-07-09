package hello.listeners;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;

import hello.Calculator;

public class PlusButtonListenerImpl implements ComponentEventListener {
	Calculator cal;

	public PlusButtonListenerImpl(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void onComponentEvent(ComponentEvent event) {
		cal.outputTF.setValue(Integer.toString(cal.getIntInput1() + cal.getIntInput2()));
	}

}