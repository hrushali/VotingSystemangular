import { useAnimation } from '@angular/animations';
import { Routes } from '@angular/router';
import { UserLogincomponantComponent } from './user-logincomponant/user-logincomponant.component';
import { HomecomponantComponent } from './homecomponant/homecomponant.component';
import { AdminlogincomponantComponent } from './adminlogincomponant/adminlogincomponant.component';
import { AboutcomponantComponent } from './aboutcomponant/aboutcomponant.component';
import { UsersignupcomponantComponent } from './usersignupcomponant/usersignupcomponant.component';
import { CandidatecomponantComponent } from './candidatecomponant/candidatecomponant.component';
import { CandidateloginComponent } from './candidatelogin/candidatelogin.component';
import { VotescomponantComponent } from './votescomponant/votescomponant.component';
import { ResultcomponantComponent } from './resultcomponant/resultcomponant.component';
import { AdminComponent } from './admin/admin.component';

export const routes: Routes = [

{
    path:'',
    component:HomecomponantComponent

},

    {
        path:'userlogin',
        component:UserLogincomponantComponent
    },

    {
       path:'Admin',
       component:AdminlogincomponantComponent
    },

    {
        path:'about',
        component:AboutcomponantComponent
        
    },
    {
       path:"signup",
       component:UsersignupcomponantComponent 
    },
    {
        path:"candidatesignup",
        component:CandidatecomponantComponent
    },
    {
        path:"candidates",
        component:CandidateloginComponent
    },
    {
        path:'votes',
        component:VotescomponantComponent
    },
    {
        path:"result",
        component:ResultcomponantComponent
    },
    {
        path:"admindashboard",
        component:AdminComponent
    }
];
