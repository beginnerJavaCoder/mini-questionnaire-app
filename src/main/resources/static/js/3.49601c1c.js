(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[3],{"8dbd":function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("q-page",{staticClass:"flex flex-center"},[t.isChangesApproved?s("div",[s("p",{staticClass:"text-h5 q-mt-lg q-mb-lg q-ml-sm"},[t._v("Изменения успешно сохранены!")]),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{to:"/",label:"Назад",outline:"",color:"primary"}})],1)]):s("div",{staticClass:"q-pa-md"},[s("q-form",{staticClass:"q-gutter-md",on:{submit:t.onSubmit}},[s("q-card",{staticClass:"my-card"},[s("q-card-section",[s("q-input",{attrs:{outlined:"",label:"Название анкеты"},model:{value:t.questionnaire.title,callback:function(e){t.$set(t.questionnaire,"title",e)},expression:"questionnaire.title"}})],1)],1),t._l(t.questionnaire.questions,(function(e,i){return s("div",{key:i,staticClass:"q-gutter-md"},[s("q-card",{staticClass:"my-card"},[s("q-card-section",[s("q-input",{attrs:{outlined:"",label:i+1+"й вопрос"},model:{value:e.description,callback:function(s){t.$set(e,"description",s)},expression:"question.description"}}),s("div",{staticClass:"q-gutter-sm"},[s("q-checkbox",{attrs:{label:"На этот вопрос можно дать несколько ответов?"},model:{value:e.hasMultipleAnswers,callback:function(s){t.$set(e,"hasMultipleAnswers",s)},expression:"question.hasMultipleAnswers"}})],1),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{label:"Добавить вариант ответа",outline:"",color:"primary"},on:{click:function(e){return t.addAnswerOption(i)}}})],1),t._l(e.answerOptions,(function(e,i){return s("div",{key:i},[s("q-input",{attrs:{outlined:"",label:i+1+"й вариант ответа"},model:{value:e.description,callback:function(s){t.$set(e,"description",s)},expression:"answer.description"}})],1)}))],2)],1)],1)})),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{label:"Добавить новый вопрос",outline:"",color:"primary"},on:{click:t.addQuestion}})],1),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{label:"Сохранить",type:"submit",outline:"",color:"primary"}})],1)],2)],1)])},n=[],a=(s("e6cf"),s("ddb0"),s("c973")),r=s.n(a),o={name:"EditQuestionnaire",data(){return{questionnaire:this.getQuestionnaire(),isChangesApproved:!1}},methods:{getQuestionnaire(){const t=this.$store.getters["questionnaireStore/getAllQuestionnaires"];for(const e of t)if(e.id===+this.$router.currentRoute.params.id)return e},onSubmit(){var t=this;return r()((function*(){const e={title:t.questionnaire.title,questions:t.questionnaire.questions},s=yield fetch("http://localhost:8080/questionnaires/"+t.questionnaire.id,{method:"PUT",headers:{"Content-Type":"application/json",Authorization:"Bearer "+t.$store.getters["userStore/getToken"]},body:JSON.stringify(e)});s.ok&&(t.isChangesApproved=!0)}))()},addAnswerOption(t){this.questionnaire.questions[t].answerOptions.push({description:""})},addQuestion(){this.questionnaire.questions.push({description:"Новый вопрос",hasMultipleAnswers:!1,answerOptions:[{description:"Первый вариант ответа"},{description:"Второй вариант ответа"}]})}}},l=o,c=s("2877"),u=s("9989"),d=s("0378"),p=s("f09f"),q=s("a370"),f=s("27f9"),b=s("8f8e"),m=s("9c40"),h=s("eebe"),v=s.n(h),C=Object(c["a"])(l,i,n,!1,null,null,null);e["default"]=C.exports;v()(C,"components",{QPage:u["a"],QForm:d["a"],QCard:p["a"],QCardSection:q["a"],QInput:f["a"],QCheckbox:b["a"],QBtn:m["a"]})}}]);