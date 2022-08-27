import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicalFileListComponent} from './medicalFile/medicalFileList/medicalFileList.component';
import {MedicalFileEditComponent} from './medicalFile/medicalFileEdit/medicalFileEdit.component';
import {MedicalFileCreateComponent} from './medicalFile/medicalFileCreate/medicalFileCreate.component';


const routes: Routes = [
  {path: '', component: MedicalFileListComponent},
  {path: 'edit/:id', component: MedicalFileEditComponent},
  {path: 'create', component: MedicalFileCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
