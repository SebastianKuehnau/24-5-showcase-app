package com.example.application.views.reactcomponent;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.theme.lumo.LumoUtility;

@NpmPackage(value = "rc-slider", version = "^11.1.7")
@JsModule("./components/my-slider.tsx")
@Tag("my-slider")
public class MySlider extends ReactAdapterComponent {

    public MySlider() {
        super();
        addClassNames("w-full", "h-full");
    }

    public Number getValue() {
        return getState("sliderValue", Number.class);
    }

    public void setValue(Number value) {
        setState("sliderValue", value);
    }

    public void addValueChangeListener(
            SerializableConsumer<Number> listener) {
        addStateChangeListener("sliderValue", Number.class, listener);
    }

}
