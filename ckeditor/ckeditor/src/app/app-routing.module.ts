import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListComponent} from './notification/list/list.component';
import {CreateComponent} from './notification/create/create.component';


const routes: Routes = [{
  path: '', component: ListComponent
},
  {
    path: 'add', component: CreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
