(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[10],{a6e1:function(e,t,s){"use strict";s.r(t);var n=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("q-page",{staticClass:"flex flex-center"},[e.isPass?s("div",{staticClass:"text-h5 q-mt-lg q-mb-lg q-ml-sm"},[s("p",[e._v("Вы успешно прошли анкету!")]),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{to:"/",label:"На главную",outline:"",color:"primary"}})],1)]):s("div",{staticClass:"q-pa-md"},[s("div",{staticClass:"q-gutter-md"},[s("q-form",{staticClass:"q-gutter-md",on:{submit:e.onSubmit}},[s("q-item-label",{staticClass:"text-h4"},[e._v(e._s(e.questionnaire.title))]),s("br"),e._l(e.questionnaire.questions,(function(t,n){return s("div",{key:t.id,attrs:{question:t}},[s("q-card",{staticClass:"my-card"},[s("q-card-section",[s("div",[s("p",{staticClass:"text-h6 flex-center flex q-gutter-md"},[e._v(e._s(t.description))]),e._l(t.answerOptions,(function(i,r){return s("div",{key:i.id},[s("div",{staticClass:"q-pa-md"},[t.hasMultipleAnswers?s("div",{staticClass:"q-gutter-sm text-h6"},[s("q-checkbox",{attrs:{label:i.description},model:{value:e.multipleAnswersModel[n][r],callback:function(t){e.$set(e.multipleAnswersModel[n],r,t)},expression:"multipleAnswersModel[questionIndex][answerIndex]"}})],1):s("div",{staticClass:"text-h6 q-gutter-sm"},[s("q-radio",{attrs:{val:i,label:i.description},model:{value:e.singleAnswers[n],callback:function(t){e.$set(e.singleAnswers,n,t)},expression:"singleAnswers[questionIndex]"}})],1)])])}))],2)])],1)],1)})),s("div",{staticClass:"flex flex-center"},[s("q-btn",{attrs:{label:"Отправить",type:"submit",outline:"",color:"primary"}})],1)],2)],1)])])},i=[],r=(s("e6cf"),s("ddb0"),s("c973")),a=s.n(r),l={data(){return{questionnaire:this.getQuestionnaire(),singleAnswers:[],multipleAnswersModel:this.init(),isPass:!1}},methods:{getQuestionnaire(){const e=this.$store.getters["questionnaireStore/getAllQuestionnaires"];for(const t of e)if(t.id===+this.$router.currentRoute.params.id)return t},init(){const e=this.getQuestionnaire(),t=[];let s,n=0;for(const i of e.questions)if(i.hasMultipleAnswers){s=[];for(let e=0;e<i.answerOptions.length;e++)s.push(!1);t[n++]=s}else t[n++]=[];return t},onSubmit(){var e=this;return a()((function*(){const t=[];for(const i of e.singleAnswers)i&&t.push(i);for(let i=0;i<e.multipleAnswersModel.length;i++)for(let s=0;s<e.multipleAnswersModel[i].length;s++)!0===e.multipleAnswersModel[i][s]&&t.push(e.questionnaire.questions[i].answerOptions[s]);const s={answers:t,username:e.$store.getters["userStore/getUsername"]},n=yield fetch("http://localhost:8080/questionnaires/passing",{method:"POST",headers:{"Content-Type":"application/json",Authorization:"Bearer "+e.$store.getters["userStore/getToken"]},body:JSON.stringify(s)});n.ok&&(e.isPass=!0)}))()}}},o=l,u=s("2877"),c=s("9989"),d=s("0378"),p=s("0170"),m=s("f09f"),f=s("a370"),q=s("8f8e"),h=s("3786"),g=s("9c40"),w=s("eebe"),b=s.n(w),x=Object(u["a"])(o,n,i,!1,null,null,null);t["default"]=x.exports;b()(x,"components",{QPage:c["a"],QForm:d["a"],QItemLabel:p["a"],QCard:m["a"],QCardSection:f["a"],QCheckbox:q["a"],QRadio:h["a"],QBtn:g["a"]})}}]);