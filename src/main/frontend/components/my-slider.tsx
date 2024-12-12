import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React, { ReactElement } from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';

class MySliderElement extends ReactAdapterElement {
  protected override render(hooks: RenderHooks): ReactElement | null {
    const [sliderValue, setSliderValue] = hooks.useState<number>('sliderValue');

    return <Slider
              value={sliderValue}
              onChange={value => setSliderValue(Number(value))}
            />;
  }
}

customElements.define('my-slider', MySliderElement);