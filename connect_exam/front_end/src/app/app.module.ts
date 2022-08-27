import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {MedicalFileEditComponent} from './medicalFile/medicalFileEdit/medicalFileEdit.component';
import {MedicalFileListComponent} from './medicalFile/medicalFileList/medicalFileList.component';
import {MedicalFileCreateComponent} from './medicalFile/medicalFileCreate/medicalFileCreate.component';
import { PatientListComponent } from './patient/patient-list/patient-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MedicalFileEditComponent,
    MedicalFileListComponent,
    MedicalFileCreateComponent,
    PatientListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 1000,
      progressBar: true,
      progressAnimation: 'increasing',
      preventDuplicates: true
    }),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
