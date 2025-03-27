
# TODO : the image-processing engine that detects if an image is NSFW and returns a score; and describes the image (if it's SFW)

class ImageEngine:

    def __init__ ( self ):
        pass



    def isNsfwProbability ( self , image:str ) -> float: 
        pass

    def isNsfw ( self , image:str ) -> bool:
        pass



    def describeImage ( self , image:str ) -> str:
        pass



    def processImage ( self , image:str ) -> str|bool:
        pass



def main () -> str|bool:
    
    # TODO : takes an image path as a parameter from command line and returns the result of the image processing
    pass