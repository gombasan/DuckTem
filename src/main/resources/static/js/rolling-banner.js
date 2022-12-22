window.addEventListener('load', function(){
    let vectorLeft = this.document.querySelector('.vector-left');
    let vectorRight = this.document.querySelector('.vector-right');
    let bannerWrap = document.querySelector('.banner-wrap');

    let current = 0;
    
    let interval = setInterval(auto = function(){
        if(current<3){
            current++;
        }
        if(current<=-1 || current==3)
            current=0;


        if(current==0)
            bannerWrap.style.transform = 'translate(0vw)';
        else if(current==1)
            bannerWrap.style.transform = 'translate(-100vw)';
        else if(current==2)
            bannerWrap.style.transform = 'translate(-200vw)';
    },6000)


	

    vectorLeft.onclick = function(e) {
		
		clearInterval(interval);
		
		
        if(current>-1){
            current--;
        }
        if(current>=3 || current==-1)
            current=2;

        if(current==0)
            bannerWrap.style.transform = 'translate(0vw)';
        else if(current==1)
            bannerWrap.style.transform = 'translate(-100vw)';
        else if(current==2)
            bannerWrap.style.transform = 'translate(-200vw)';
        
        interval = setInterval(auto,6000);
    }

    vectorRight.onclick = function(e) {
		
		clearInterval(interval);
		
		
        if(current<3){
            current++;
        }
        if(current<=-1 || current==3)
            current=0;


        if(current==0)
            bannerWrap.style.transform = 'translate(0vw)';
        else if(current==1)
            bannerWrap.style.transform = 'translate(-100vw)';
        else if(current==2)
            bannerWrap.style.transform = 'translate(-200vw)';
                        
        interval = setInterval(auto,6000);
		            
    }
});