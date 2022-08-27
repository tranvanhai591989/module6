import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {MedicalFileService} from '../../service/medicalFile.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-medicalFileEdit',
  templateUrl: './medicalFileEdit.component.html',
  styleUrls: ['./medicalFileEdit.component.css']
})
export class MedicalFileEditComponent implements OnInit {

  medicalFileForm: FormGroup;
  id: number;

  constructor(private medicalFileService: MedicalFileService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getMedicalFile(this.id);
    });
  }

  getMedicalFile(id: number) {
    this.medicalFileService.findById(id).subscribe(medicalFile => {
      this.medicalFileForm = new FormGroup({
        medicalFileCode: new FormControl(medicalFile.medicalFileCode),
        patientCode: new FormControl(medicalFile.patientCode),
        patientName: new FormControl(medicalFile.patientName, [
          Validators.required,
          Validators.pattern(/^([A-Z][^A-Z0-9\s]+)(\s[A-Z][^A-Z0-9\s]+)*$/)]),
        reason: new FormControl(medicalFile.reason,
          [Validators.required,
            Validators.minLength(3)]),
        treatments: new FormControl(medicalFile.treatments, [Validators.required, Validators.minLength(3)]),
        doctor: new FormControl(medicalFile.doctor, [Validators.required,
          Validators.pattern(/^([A-Z][^A-Z0-9\s]+)(\s[A-Z][^A-Z0-9\s]+)*$/)]),
        checkNowFuture: new FormGroup({
          startDay: new FormControl(medicalFile.startDay, [Validators.required]),
          endDay: new FormControl(medicalFile.endDay, [Validators.required]),
        }, this.checkDay),
      });
    });
  }

  checkDay(check: AbstractControl) {
    const startDay = new Date(check.value.ngayNhapVien);
    const endDay = new Date(check.value.ngayXuatVien);
    if (startDay.getTime() > endDay.getTime()) {
      return {dayError: true};
    }
  }

  update() {
    const medicalFile = this.medicalFileForm.value;
    medicalFile.startDay = this.medicalFileForm.get('checkNowFuture').value.startDay;
    medicalFile.endDay = this.medicalFileForm.get('checkNowFuture').value.endDay;
    this.medicalFileService.updateMedicalFile(this.id, medicalFile).subscribe(() => {
      this.medicalFileForm.reset();
      this.router.navigateByUrl('/');
      this.toastr.success('Edit success', ' ', {
        timeOut: 1500, progressBar: false
      });
    });
  }

}
