import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webapp';

  onDrop(event: Event) {
    event.preventDefault();
    let draggedData = event.dataTransfer.files;
  }

  onDragOver(event: Event) {
    // Prevent default behavior (Prevent file from being opened)
    event.preventDefault();
  }

}
