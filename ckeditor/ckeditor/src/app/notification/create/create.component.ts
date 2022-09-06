import {Component, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ChangeEvent} from '@ckeditor/ckeditor5-angular';
import {NotificationService} from '../../service/notification.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  constructor(private notificationService: NotificationService,
              private router: Router) {
  }

  public editor = ClassicEditor;
  public html: string;
  notificationForm: FormGroup = new FormGroup({
    content: new FormControl(''),
    date: new FormControl(Date())
  });

  ngOnInit(): void {
  }

  submit() {
    const notification = this.notificationForm.value;
    this.notificationService.save(notification).subscribe(() => {
      alert('Thêm mới thành công');
      this.router.navigate([]);
      this.notificationForm.reset();
    }, e => console.log(e));
  }

  change({editor}: ChangeEvent) {
    const EditorData = editor.getData();

    this.notificationForm.get('description').setValue(EditorData);
  }

}
