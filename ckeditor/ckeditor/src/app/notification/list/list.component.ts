import { Component, OnInit } from '@angular/core';
import {NotificationService} from '../../service/notification.service';
import {Notification} from '../../model/notification';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  notification: Notification[];

  constructor(private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.notificationService.findAll().subscribe(notification => {
      this.notification = notification;
    });
  }
}
