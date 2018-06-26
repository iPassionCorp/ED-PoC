import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
 selector: '[NumberOnly]'
})
export class NumberOnlyDirective {
    regexStr = '[0-9]';

    constructor(private el: ElementRef) {}
    @HostListener('keydown', ['$event']) onKeyDown(event) {
    let e = <KeyboardEvent> event;
    // 46 = delete , 8 = Backspace , 9 = tab ,
    // 27 = esc , 13 = enter , 110 = . , 190 notShift = . , 188 notShoft = ,
    if ([46, 8, 9, 27, 13].indexOf(e.keyCode) !== -1 ||
    // Allow: Ctrl+A
    (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
    // Allow: Ctrl+C
    (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) ||
    // Allow: Ctrl+X
    (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) ||
    // Allow: home, end, left, right
    (e.keyCode >= 35 && e.keyCode <= 39)){
      // let it happen, don't do anything
      return;
    }
    let regEx =  new RegExp(this.regexStr);
    let char: string;
    if (typeof e.key != 'undefined'){
        char = e.key;
    }else{
        char = e.code.substring(e.code.length - 1);
    }
    if(!regEx.test(char)){
      e.preventDefault();
    }
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
      e.preventDefault();
    }
  }
}