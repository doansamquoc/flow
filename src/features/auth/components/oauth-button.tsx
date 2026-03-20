import { Button } from "@/components/ui/button";
import type { Provider } from "../types/provider.type";
import { useOAuthFlow } from "../hooks/use-oauth-flow";
import { Spinner } from "@/components/ui/spinner";
import { providerConfig } from "../configs/provider.config";

interface OAuthButtonProps {
  provider: Provider;
}

const OAuthButton = ({ provider }: OAuthButtonProps) => {
  const { handleLogin, loading } = useOAuthFlow();
  const config = providerConfig[provider];

  return (
    <Button
      variant={"outline"}
      size={"lg"}
      type='button'
      className='w-full relative'
      onClick={() => handleLogin(provider)}
      disabled={loading}
    >
      {loading ? (
        <Spinner />
      ) : (
        <>
          <img
            src={config.icon}
            alt={provider}
            className='absolute size-5 left-4'
          />
          {config.label}
        </>
      )}
    </Button>
  );
};

export default OAuthButton;
