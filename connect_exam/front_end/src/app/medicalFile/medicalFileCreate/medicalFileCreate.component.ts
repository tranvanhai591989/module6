import {Component, OnInit} from '@angular/core';
import {MedicalFile} from '../../model/medicalFile';
import {FormControl, FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {MedicalFileService} from '../../service/medicalFile.service';

@Component({
  selector: 'app-medicalFileCreate',
  templateUrl: './medicalFileCreate.component.html',
  styleUrls: ['./medicalFileCreate.component.css']
})
export class MedicalFileCreateComponent implements OnInit {

  medical: MedicalFile [] = [];
  medicalForm: FormGroup = new FormGroup({
    id: new FormControl(),
    codePatient: new FormControl(),
    codePeoplePatient: new FormControl(),
    namePeoplePatient: new FormControl(),
    dayStart: new FormControl(),
    dayEnd: new FormControl(),
    reason: new FormControl(),
    method: new FormControl(),
    doctor: new FormControl(),
  });

  constructor(private toastr: ToastrService,
              private router: Router,
              private medicalFileService: MedicalFileService) {
  }

  ngOnInit() {
  }

  submit() {
    const medicalFile = this.medicalForm.value;
    this.medicalFileService.save(medicalFile).subscribe(() => {
      this.medicalForm.reset();
      this.router.navigateByUrl('/list');
      this.toastr.success('Create success', ' ', {
        timeOut: 1500, progressBar: false
      });
    });
  }
}
