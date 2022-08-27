import {Component, OnInit} from '@angular/core';
import {MedicalFile} from '../../model/medicalFile';
import {MedicalFileService} from '../../service/medicalFile.service';

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-medicalFileList',
  templateUrl: './medicalFileList.component.html',
  styleUrls: ['./medicalFileList.component.css']
})
export class MedicalFileListComponent implements OnInit {
  patients: MedicalFile[] = [];
  medicalFileCode: string;
  id: number;
  p = 1;

  constructor(private medicalFileService: MedicalFileService) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    return this.medicalFileService.getAll().subscribe(next => {
      this.patients = next;
    });
  }

  openDelete(id: number, medicalFileCode: string) {
    this.id = id;
    this.medicalFileCode = medicalFileCode;
  }

  delete(id: number): void {
    this.medicalFileService.delete(id).subscribe(() => {
      this.getAll();
    });
  }

}
